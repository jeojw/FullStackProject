package com.example.demo.Diet.Rice;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiceDto {
    private String name;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;
    @Transactional
    public static RiceDto toRiceDto(RiceEntity riceEntity){
        return RiceDto.builder()
                .name(riceEntity.getName())
                .calorie(riceEntity.getCalorie())
                .carbohydrate(riceEntity.getCarbohydrate())
                .protein(riceEntity.getProtein())
                .province(riceEntity.getProvince())
                .build();
    }
}
