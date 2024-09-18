package com.example.demo.Diet;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class DietDto {
    private String Name;

    private int Calorie;

    private int Carbohydrate;

    private int Protein;

    private int Province;

    private String RecipeLink;

    public DietDto(String name, int calorie,
                   int carbohydrate, int protein, int province,
                   String recipeLink)
    {
        this.Name = name;
        this.Calorie = calorie;
        this.Carbohydrate = carbohydrate;
        this.Protein = protein;
        this.Province = province;
        this.RecipeLink = recipeLink;
    }
}
