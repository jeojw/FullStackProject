package com.example.demo.Diet;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class SortDietRequestDto {
    private String userEmail;
    private List<DietDto> dietList;
    private String nutrient;
    private String sortOption;
}
