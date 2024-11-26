package com.example.demo.Diet.SideDish;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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
