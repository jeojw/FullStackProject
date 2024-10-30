package com.example.demo.Diet.SideDish;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SideDishDto {
    private String name;
    private String classification;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;

    public static SideDishDto toSideDishDto(SideDishEntity sideDishEntity){
        return SideDishDto.builder()
                .name(sideDishEntity.getName())
                .classification(sideDishEntity.getClassification())
                .calorie(sideDishEntity.getCalorie())
                .carbohydrate(sideDishEntity.getCarbohydrate())
                .protein(sideDishEntity.getProtein())
                .province(sideDishEntity.getProvince())
                .build();
    }
}
