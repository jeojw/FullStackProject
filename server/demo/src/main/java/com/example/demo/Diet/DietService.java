package com.example.demo.Diet;

import com.example.demo.Diet.DietSideDish.DietSideDishEntity;
import com.example.demo.Diet.DietSideDish.DietSideDishRepository;
import com.example.demo.Diet.Rice.RiceEntity;
import com.example.demo.Diet.Rice.RiceRepository;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.Diet.SideDish.SideDishRepository;
import com.example.demo.Diet.Soup.SoupEntity;
import com.example.demo.Diet.Soup.SoupRepository;
import com.example.demo.User.UserEntity;
import com.example.demo.User.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DietService {

    private final UserRepository userRepository;
    private final DietRepository dietRepository;
    private final RiceRepository riceRepository;
    private final SoupRepository soupRepository;
    private final SideDishRepository sideDishRepository;
    private final DietSideDishRepository dietSideDishRepository;

    private final List<List<FoodDto>> FoodSets = new ArrayList<>();
    private final List<List<FoodDto>> DietList = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<RiceEntity> riceList = riceRepository.getRiceEntityList();
        List<SoupEntity> soupEntityList = soupRepository.getSoupEntityList();
        List<SideDishEntity> sideDishEntityList_1 = sideDishRepository.getSideDishEntityList_1();
        List<SideDishEntity> sideDishEntityList_2 = sideDishRepository.getSideDishEntityList_2();
        List<SideDishEntity> sideDishEntityList_3 = sideDishRepository.getSideDishEntityList_3();

        riceList.sort(Comparator.comparing(RiceEntity::getCarbohydrate).reversed());
        soupEntityList.sort(Comparator.comparing(SoupEntity::getCarbohydrate).reversed());
        sideDishEntityList_1.sort(Comparator.comparing(SideDishEntity::getProtein).reversed());
        sideDishEntityList_2.sort(Comparator.comparing(SideDishEntity::getProvince).reversed());
        sideDishEntityList_3.sort(Comparator.comparing(SideDishEntity::getProtein).reversed()
                .thenComparing(Comparator.comparing(SideDishEntity::getProvince).reversed()));

        FoodSets.add(ChangeRiceToFood(riceList));
        FoodSets.add(ChangeSoupToFood(soupEntityList));
        FoodSets.add(ChangeSideDishToFood(sideDishEntityList_1));
        FoodSets.add(ChangeSideDishToFood(sideDishEntityList_2));
        FoodSets.add(ChangeSideDishToFood(sideDishEntityList_3));
    }

    @Async
    public CompletableFuture<List<DietDto>> getDietList(String userEmail){
        Optional<UserEntity> userEntity = userRepository.findByEmail(userEmail);
        if (userEntity.isPresent()){
            List<DietEntity> entityList = dietRepository.returnSearchDiets(userEntity.get().getId());
            List<DietDto> dtoList = new ArrayList<>();

            for (DietEntity entity : entityList){
                dtoList.add(DietDto.toDietDto(entity));
            }
            return CompletableFuture.completedFuture(dtoList);
        }
        else{
            return null;
        }
    }

    @Async
    public CompletableFuture<List<DietDto>> searchDietListByOption(SearchDto searchDto){
        Optional<UserEntity> user = userRepository.findByEmail(searchDto.getUserEmail());
        ArrayList<DietDto> returnList = new ArrayList<>();
        if (user.isPresent()){
            Optional<List<Long>> riceIdList = riceRepository.getRiceEntityId(searchDto.getSearchRice().trim());
            Optional<List<Long>> soupIdList = soupRepository.getSoupEntityId(searchDto.getSearchSoup().trim());
            Optional<List<Long>> sideDishIdList = sideDishRepository.getSideDishEntityId(searchDto.getSearchSideDish().trim());

            if (riceIdList.isPresent() && soupIdList.isPresent() && sideDishIdList.isPresent()){
                Optional<List<DietEntity>> searchList = dietRepository.searchDietList(user.get().getId(), riceIdList.get(), soupIdList.get());
                System.out.println("DietList: " + searchList + "\n");
                if (searchList.isPresent()){
                    for (DietEntity entity: searchList.get()){
                        if (dietSideDishRepository.existsByUserIdAndDietIdAndSideDishIdIn(user.get().getId(), entity.getId(), sideDishIdList.get())) {
                            returnList.add(DietDto.toDietDto(entity));
                        }
                    }
                    return CompletableFuture.completedFuture(returnList);
                }
                else{
                    return null;
                }
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    @Async
    public CompletableFuture<List<DietDto>> searchDietList(String userEmail, double BMR, int activeCoef){
        Optional<UserEntity> userEntity = userRepository.findByEmail(userEmail);
        if (userEntity.isPresent()){
            List<DietEntity> entityList;
            List<DietDto> dtoList = new ArrayList<>();

            double calorie = BMR * activeCoef;
            double min_carb = calorie * 0.55 / 12;
            double max_carb = calorie * 0.65 / 12;
            double min_protein = calorie * 0.07 / 12;
            double max_protein = calorie * 0.2 / 12;
            double min_province = calorie * 0.15 / 27;
            double max_province = calorie * 0.25 / 27;

            double carb = min_carb * 0.5 + max_carb * 0.5;
            double protein = min_protein * 0.5 + max_protein * 0.5;
            double province = min_province * 0.5 + max_province * 0.5;

            dietSideDishRepository.deleteDietSideList(userEntity.get().getId());
            dietRepository.deleteDietList(userEntity.get().getId());
            SetDietList(new ArrayList<>(), 0,
                    0, 0, 0,
                    carb, protein, province);
            StoreDietList(userEntity.get(), DietList);
            entityList = dietRepository.returnSearchDiets(userEntity.get().getId());

            for (DietEntity entity : entityList){
                dtoList.add(DietDto.toDietDto(entity));
            }
            return CompletableFuture.completedFuture(dtoList);
        }
        else{
            return null;
        }
    }
    @Async
    public CompletableFuture<DietDto> getDiet(Long id){
        if (dietRepository.findById(id.intValue()).isPresent()){
            DietEntity entity = dietRepository.findById(id.intValue()).get();
            return CompletableFuture.completedFuture(DietDto.toDietDto(entity));
        }
         else{
             return null;
        }
    }
    @Async
    public void StoreDietList(UserEntity user, List<List<FoodDto>> DietList){
        if (!DietList.isEmpty()){
            for (List<FoodDto> foodDtos : DietList) {
                DietEntity dietEntity = new DietEntity(
                        riceRepository.getRiceEntity(foodDtos.get(0).getName()),
                        soupRepository.getSoupEntity(foodDtos.get(1).getName()),
                        user
                );
                for (int j = 2; j < foodDtos.size(); j++) {
                    DietSideDishEntity dietSideDishEntity = new DietSideDishEntity();
                    dietSideDishEntity.setUser(user);
                    dietSideDishEntity.setSideDish(sideDishRepository.getSideDishEntity(foodDtos.get(j).getName()));
                    dietSideDishEntity.setDiet(dietEntity);
                    dietEntity.addDietSideDish(dietSideDishEntity);
                }
                if (!dietRepository.existsByCarbohydrateAndProteinAndProvince(
                        dietEntity.getCarbohydrate(),
                        dietEntity.getProtein(),
                        dietEntity.getProvince())){
                    dietEntity.setCalorie();
                    dietEntity.setCarbohydrate();
                    dietEntity.setProtein();
                    dietEntity.setProvince();
                    dietRepository.save(dietEntity);
                }
            }
        }
    }
    @Async
    public void SetDietList(List<FoodDto> indices, int depth,
                            double sum_carbohydrate, double sum_protein, double sum_province,
                            double carbohydrate, double protein, double province) {

        if (depth >= FoodSets.size()) {
            return;
        }

        if (isValidDiet(sum_carbohydrate, sum_protein, sum_province, carbohydrate, protein, province)) {
            DietList.add(new ArrayList<>(indices));
            return;
        }

        double localCoef = getLocalCoef(depth);

        for (FoodDto food : FoodSets.get(depth)) {
            // 목표를 초과한 값은 더 이상 처리하지 않음
            if (sum_carbohydrate + food.getCarbohydrate() * localCoef > carbohydrate ||
                    sum_protein + food.getProtein() * localCoef > protein ||
                    sum_province + food.getProvince() * localCoef > province) {
                continue;
            }

            indices.add(food);
            SetDietList(indices, depth + 1,
                    sum_carbohydrate + food.getCarbohydrate() * localCoef,
                    sum_protein + food.getProtein() * localCoef,
                    sum_province + food.getProvince() * localCoef,
                    carbohydrate, protein, province);
            indices.remove(indices.size() - 1);
        }
    }

    private boolean isValidDiet(double sum_carbohydrate, double sum_protein, double sum_province,
                                double carbohydrate, double protein, double province) {
        return sum_carbohydrate >= carbohydrate * 0.9 && sum_carbohydrate <= carbohydrate * 1.1 &&
                sum_protein >= protein * 0.9 && sum_protein <= protein * 1.1 &&
                sum_province >= province * 0.9 && sum_province <= province * 1.1;
    }

    private double getLocalCoef(int depth) {
        if (depth < 2) {
            return 1.5;
        } else if (depth == 2) {
            return 1;
        } else {
            return 0.5;
        }
    }

    public List<FoodDto> ChangeRiceToFood(List<RiceEntity> entityList){
        List<FoodDto> returnList = new ArrayList<>();
        for (RiceEntity riceEntity : entityList){
            returnList.add(FoodDto.builder()
                            .name(riceEntity.getName())
                            .calorie(riceEntity.getCalorie())
                            .carbohydrate(riceEntity.getCarbohydrate())
                            .protein(riceEntity.getProtein())
                            .province(riceEntity.getProvince())
                            .build());
        }

        return returnList;
    }

    public List<FoodDto> ChangeSoupToFood(List<SoupEntity> entityList){
        List<FoodDto> returnList = new ArrayList<>();
        for (SoupEntity soupEntity : entityList){
            returnList.add(FoodDto.builder()
                    .name(soupEntity.getName())
                    .calorie(soupEntity.getCalorie())
                    .carbohydrate(soupEntity.getCarbohydrate())
                    .protein(soupEntity.getProtein())
                    .province(soupEntity.getProvince())
                    .build());
        }

        return returnList;
    }

    public List<FoodDto> ChangeSideDishToFood(List<SideDishEntity> entityList){
        List<FoodDto> returnList = new ArrayList<>();
        for (SideDishEntity sideDishEntity : entityList){
            returnList.add(FoodDto.builder()
                    .name(sideDishEntity.getName())
                    .classification(sideDishEntity.getClassification())
                    .calorie(sideDishEntity.getCalorie())
                    .carbohydrate(sideDishEntity.getCarbohydrate())
                    .protein(sideDishEntity.getProtein())
                    .province(sideDishEntity.getProvince())
                    .build());
        }

        return returnList;
    }
    @Async
    public CompletableFuture<List<DietDto>> sortDietList(List<DietDto> list, String nutrient, String sortOption){
        if (Objects.equals(nutrient, "Calorie")){
            if (Objects.equals(sortOption, "Upper")){
                list.sort(Comparator.comparing(DietDto::getCalorie));
            }
            else{
                list.sort(Comparator.comparing(DietDto::getCalorie).reversed());
            }
            return CompletableFuture.completedFuture(list);
        }
        else if (Objects.equals(nutrient, "Carbohydrate")){
            if (Objects.equals(sortOption, "Upper")){
                list.sort(Comparator.comparing(DietDto::getCarbohydrate));
            }
            else{
                list.sort(Comparator.comparing(DietDto::getCarbohydrate).reversed());
            }
            return CompletableFuture.completedFuture(list);
        }
        else if (Objects.equals(nutrient, "Protein")){
            if (Objects.equals(sortOption, "Upper")){
                list.sort(Comparator.comparing(DietDto::getProtein));
            }
            else{
                list.sort(Comparator.comparing(DietDto::getProtein).reversed());
            }
            return CompletableFuture.completedFuture(list);
        }
        else{
            if (Objects.equals(sortOption, "Upper")){
                list.sort(Comparator.comparing(DietDto::getProvince));
            }
            else{
                list.sort(Comparator.comparing(DietDto::getProvince).reversed());
            }
            return CompletableFuture.completedFuture(list);
        }
    }
}
