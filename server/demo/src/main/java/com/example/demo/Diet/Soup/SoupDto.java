package com.example.demo.Diet.Soup;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoupDto {
    private String name;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;
    @Transactional
    public static SoupDto toSoupDto(SoupEntity soupEntity){
        return SoupDto.builder()
                .name(soupEntity.getName())
                .calorie(soupEntity.getCalorie())
                .carbohydrate(soupEntity.getCarbohydrate())
                .protein(soupEntity.getProtein())
                .province(soupEntity.getProvince())
                .build();
    }
}
