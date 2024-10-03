package com.example.demo.Diet.SideDish;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class SideDishDto {
    private String Name;
    private String Classification;
    private double Calorie;
    private double Carbohydrate;
    private double Protein;
    private double Province;
}
