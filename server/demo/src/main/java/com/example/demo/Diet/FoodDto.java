package com.example.demo.Diet;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class FoodDto {
    private String Name;
    private String Classification;
    private double Calorie;
    private double Carbohydrate;
    private double Protein;
    private double Province;
}
