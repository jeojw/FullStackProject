package com.example.demo.Diet.Soup;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class SoupDto {
    private String Name;
    private double Calorie;
    private double Carbohydrate;
    private double Protein;
    private double Province;

}
