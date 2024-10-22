package com.example.demo;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BodyInfoDto {
    private double BMR;
    private int activeCoef;
}
