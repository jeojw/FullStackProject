package com.example.demo.Diet.Rice;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class RiceDto {
    private String Name;
    private double Calorie;
    private double Carbohydrate;
    private double Protein;
    private double Province;
}
