package com.example.demo.Diet;

import com.example.demo.Diet.DietSideDish.DietSideDishDto;
import com.example.demo.Diet.DietSideDish.DietSideDishEntity;
import com.example.demo.Diet.Rice.RiceDto;
import com.example.demo.Diet.Soup.SoupDto;
import com.example.demo.User.UserDto;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    private Long Id;
    private RiceDto rice;
    private SoupDto soup;
    private List<DietSideDishDto> dietSideDishList;

    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;

    @Transactional
    public static DietDto toDietDto(DietEntity dietEntity){
        List<DietSideDishDto> dtoList = new ArrayList<>();
        for (DietSideDishEntity entity : dietEntity.getDietSideDishes()) {
            dtoList.add(DietSideDishDto.toDietSideDishDto(entity));
        }
        return DietDto.builder()
                .Id(dietEntity.getId())
                .rice(RiceDto.toRiceDto(dietEntity.getRice()))
                .soup(SoupDto.toSoupDto(dietEntity.getSoup()))
                .dietSideDishList(dtoList)
                .calorie(dietEntity.getCalorie())
                .carbohydrate(dietEntity.getCarbohydrate())
                .protein(dietEntity.getProtein())
                .province(dietEntity.getProvince())
                .build();
    }

    public DietDto(Long id, RiceDto rice, SoupDto soup, List<DietSideDishDto> dietSideDishDtoList)
    {
        this.Id = id;
        this.rice = rice;
        this.soup = soup;
        this.dietSideDishList = dietSideDishDtoList;
    }
}
