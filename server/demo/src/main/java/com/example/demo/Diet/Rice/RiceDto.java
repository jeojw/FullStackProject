package com.example.demo.Diet.Rice;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class RiceDto {
    private String Name;
    private int Calorie;
    private int Carbohydrate;
    private int Protein;
    private int Province;

    public RiceDto(String name, int calorie, int carbohydrate, int protein, int province){
        this.Name = name;
        this.Calorie = calorie;
        this.Carbohydrate = carbohydrate;
        this.Protein = protein;
        this.Province = province;
    }
}
