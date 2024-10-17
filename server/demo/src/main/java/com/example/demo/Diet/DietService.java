package com.example.demo.Diet;

import com.example.demo.Diet.Rice.RiceDto;
import com.example.demo.Diet.Rice.RiceEntity;
import com.example.demo.Diet.Rice.RiceRepository;
import com.example.demo.Diet.SideDish.SideDishDto;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.Diet.SideDish.SideDishRepository;
import com.example.demo.Diet.Soup.SoupDto;
import com.example.demo.Diet.Soup.SoupEntity;
import com.example.demo.Diet.Soup.SoupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DietService {

    @Autowired
    private DietRepository dietRepository;
    @Autowired
    private RiceRepository riceRepository;
    @Autowired
    private SoupRepository soupRepository;
    @Autowired
    private SideDishRepository sideDishRepository;

    private final List<RiceEntity> riceList = riceRepository.getRiceEntityList();
    private final List<SoupEntity> soupEntityList = soupRepository.getSoupEntityList();
    private final List<SideDishEntity> sideDishEntityList_1 = sideDishRepository.getSideDishEntityList_1();
    private final List<SideDishEntity> sideDishEntityList_2 = sideDishRepository.getSideDishEntityList_2();
    private final List<SideDishEntity> sideDishEntityList_3 = sideDishRepository.getSideDishEntityList_3();

    private final List<List<FoodDto>> FoodSets = new ArrayList<>();
    private final List<List<FoodDto>> DietList = new ArrayList<>();

    public List<DietDto> getDietList(double BMR, double activeCoef){
        List<DietEntity> entityList = new ArrayList<>();
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

        SetDietList(FoodSets, new ArrayList<>(), 0,
                0, 0, 0,
                carb, protein, province, 0);
        StoreDietList(DietList);
        entityList = dietRepository.returnSearchDiets();

        for (DietEntity entity : entityList){
            List<SideDishDto> tmpList = new ArrayList<>();
            for (SideDishEntity sideDishEntity : entity.getSideDish()){
                tmpList.add(SideDishDto.builder()
                                .Name(sideDishEntity.getName())
                                .Classification(sideDishEntity.getClassification())
                                .Calorie(sideDishEntity.getCalorie())
                                .Carbohydrate(sideDishEntity.getCarbohydrate())
                                .Protein(sideDishEntity.getProtein())
                                .Province(sideDishEntity.getProvince())
                                .build());
            }
            dtoList.add(DietDto.builder()
                    .Rice(RiceDto.builder()
                            .Name(entity.getRice().getName())
                            .Calorie(entity.getRice().getCalorie())
                            .Protein(entity.getRice().getProtein())
                            .Province(entity.getRice().getProvince())
                            .build())
                    .Soup(SoupDto.builder()
                            .Name(entity.getSoup().getName())
                            .Calorie(entity.getRice().getCalorie())
                            .Carbohydrate(entity.getRice().getCarbohydrate())
                            .Protein(entity.getRice().getProtein())
                            .Province(entity.getRice().getProvince())
                            .build())
                    .SideDishList(tmpList)
                    .Calorie(entity.getCalorie())
                    .Carbohydrate(entity.getCarbohydrate())
                    .Protein(entity.getProtein())
                    .Province(entity.getProvince())
                    .build());
        }
        return dtoList;
    }

    public void StoreDietList(List<List<FoodDto>> DietList){
        for (List<FoodDto> foodDtos : DietList) {
            List<SideDishEntity> sideDishEntityList = new ArrayList<>();
            for (int j = 2; j < 5; j++) {
                sideDishEntityList.add(SideDishEntity.builder()
                        .Name(foodDtos.get(j).getName())
                        .Classification(foodDtos.get(j).getClassification())
                        .Calorie(foodDtos.get(j).getCalorie())
                        .Carbohydrate(foodDtos.get(j).getCarbohydrate())
                        .Protein(foodDtos.get(j).getProtein())
                        .Province(foodDtos.get(j).getProvince())
                        .build());
            }
            dietRepository.save(DietEntity.builder()
                    .rice(RiceEntity.builder()
                            .Name(foodDtos.get(0).getName())
                            .Calorie(foodDtos.get(0).getCalorie())
                            .Carbohydrate(foodDtos.get(0).getCarbohydrate())
                            .Protein(foodDtos.get(0).getProtein())
                            .Province(foodDtos.get(0).getProvince())
                            .build())
                    .soup(SoupEntity.builder()
                            .Name(foodDtos.get(1).getName())
                            .Calorie(foodDtos.get(1).getCalorie())
                            .Carbohydrate(foodDtos.get(1).getCarbohydrate())
                            .Protein(foodDtos.get(1).getProtein())
                            .Province(foodDtos.get(1).getProvince())
                            .build())
                    .sideDish(sideDishEntityList)
                    .build());
        }

    }

    public void SetDietList(List<List<FoodDto>> FoodSets, List<FoodDto> indices, int depth,
                            double sum_carbohydrate, double sum_protein, double sum_province,
                            double carbohydrate, double protein, double province,
                            double coef){
        if (depth > FoodSets.size()){
            return;
        }

        if (indices.size() <= FoodSets.size() &&
                (sum_carbohydrate >= carbohydrate * 0.9 && sum_carbohydrate <= carbohydrate * 1.1) &&
                (sum_protein >= protein * 0.9 && sum_protein <= protein * 1.1) &&
                (sum_province >= province * 0.9 && sum_province <= protein * 1.1)){
            DietList.add(indices);
        }

        if (depth >= 0 && depth < 2){
            coef = 1.5;
        }
        else if (depth == 2){
            coef = 1;
        }
        else{
            coef = 0.5;
        }

        for (int i = 0; i < FoodSets.get(depth).size(); i++){
            if (sum_carbohydrate + FoodSets.get(depth).get(i).getCarbohydrate() * coef > carbohydrate &&
                sum_protein + FoodSets.get(depth).get(i).getProtein() * coef > protein &&
                sum_province + FoodSets.get(depth).get(i).getProvince() * coef > province){
                continue;
            }
            indices.add(FoodSets.get(depth).get(i));
            SetDietList(FoodSets, indices, depth + 1,
                    sum_carbohydrate + FoodSets.get(depth).get(i).getCarbohydrate() * coef,
                    sum_protein + FoodSets.get(depth).get(i).getProtein() * coef,
                    sum_province + FoodSets.get(depth).get(i).getProvince() * coef,
                    carbohydrate, protein, province, coef);
            indices.remove(indices.size() - 1);
        }
    }

    public List<FoodDto> ChangeRiceToFood(List<RiceEntity> entityList){
        List<FoodDto> returnList = new ArrayList<>();
        for (RiceEntity riceEntity : entityList){
            returnList.add(FoodDto.builder()
                            .Name(riceEntity.getName())
                            .Calorie(riceEntity.getCalorie())
                            .Carbohydrate(riceEntity.getCarbohydrate())
                            .Protein(riceEntity.getProtein())
                            .Province(riceEntity.getProvince())
                            .build());
        }

        return returnList;
    }

    public List<FoodDto> ChangeSoupToFood(List<SoupEntity> entityList){
        List<FoodDto> returnList = new ArrayList<>();
        for (SoupEntity soupEntity : entityList){
            returnList.add(FoodDto.builder()
                    .Name(soupEntity.getName())
                    .Calorie(soupEntity.getCalorie())
                    .Carbohydrate(soupEntity.getCarbohydrate())
                    .Protein(soupEntity.getProtein())
                    .Province(soupEntity.getProvince())
                    .build());
        }

        return returnList;
    }

    public List<FoodDto> ChangeSideDishToFood(List<SideDishEntity> entityList){
        List<FoodDto> returnList = new ArrayList<>();
        for (SideDishEntity sideDishEntity : entityList){
            returnList.add(FoodDto.builder()
                    .Name(sideDishEntity.getName())
                    .Classification(sideDishEntity.getClassification())
                    .Calorie(sideDishEntity.getCalorie())
                    .Carbohydrate(sideDishEntity.getCarbohydrate())
                    .Protein(sideDishEntity.getProtein())
                    .Province(sideDishEntity.getProvince())
                    .build());
        }

        return returnList;
    }
}
