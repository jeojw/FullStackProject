package com.example.demo;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BodyInfoDto {
    private String userEmail;
    private double BMR;
    private int activeCoef;
}
