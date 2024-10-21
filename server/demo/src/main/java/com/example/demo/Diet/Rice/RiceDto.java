package com.example.demo.Diet.Rice;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class RiceDto {
    private String name;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;
}
