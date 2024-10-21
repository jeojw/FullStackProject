package com.example.demo.Diet;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class FoodDto {
    private String name;
    private String classification;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;
}
