package com.example.demo.Diet.Soup;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class SoupDto {
    private String name;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double province;
}
