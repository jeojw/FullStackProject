package com.example.demo.User;

import lombok.*;

@Data
@Getter
@Setter
@Builder
public class NutrientDto {
    private int Calorie;
    private int Carbohydrate;
    private int Protein;
    private int Province;

    public NutrientDto(int calorie, int carbohydrate, int protein, int province)
    {
        this.Calorie = calorie;
        this.Carbohydrate = carbohydrate;
        this.Protein = protein;
        this.Province = province;
    }
}
