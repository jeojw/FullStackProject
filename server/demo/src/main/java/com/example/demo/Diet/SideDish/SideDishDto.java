package com.example.demo.Diet.SideDish;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class SideDishDto {
    private String name;
    private String classification;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;
}
