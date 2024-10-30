package com.example.demo.Diet;

import com.example.demo.Diet.DietSideDish.DietSideDishDto;
import com.example.demo.Diet.DietSideDish.DietSideDishEntity;
import com.example.demo.Diet.Rice.RiceDto;
import com.example.demo.Diet.Soup.SoupDto;
import com.example.demo.User.UserDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    private Long Id;
    private RiceDto Rice;
    private SoupDto Soup;
    private List<DietSideDishDto> DietSideDishList;

    private double Calorie;
    private double Carbohydrate;
    private double Protein;
    private double Province;

    public static DietDto toDietDto(DietEntity dietEntity){
        List<DietSideDishDto> dtoList = new ArrayList<>();
        for (DietSideDishEntity entity : dietEntity.getDietSideDishes()) {
            dtoList.add(DietSideDishDto.toDietSideDishDto(entity));
        }
        return DietDto.builder()
                .Id(dietEntity.getId())
                .Rice(RiceDto.toRiceDto(dietEntity.getRice()))
                .Soup(SoupDto.toSoupDto(dietEntity.getSoup()))
                .DietSideDishList(dtoList)
                .Calorie(dietEntity.getCalorie())
                .Carbohydrate(dietEntity.getCarbohydrate())
                .Protein(dietEntity.getProtein())
                .Province(dietEntity.getProvince())
                .build();
    }

    public DietDto(Long id, RiceDto rice, SoupDto soup, List<DietSideDishDto> dietSideDishDtoList)
    {
        this.Id = id;
        this.Rice = rice;
        this.Soup = soup;
        this.DietSideDishList = dietSideDishDtoList;

        this.Calorie = rice.getCalorie() + soup.getCalorie() + dietSideDishDtoList.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDishDto().getCalorie())
                .sum();
        this.Carbohydrate = rice.getCarbohydrate() + soup.getCarbohydrate() + dietSideDishDtoList.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDishDto().getCarbohydrate())
                .sum();
        this.Protein = rice.getProtein() + soup.getProtein() + dietSideDishDtoList.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDishDto().getProtein())
                .sum();
        this.Province = rice.getProvince() + soup.getProvince() + dietSideDishDtoList.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDishDto().getProvince())
                .sum();
    }
}
