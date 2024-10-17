package com.example.demo.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class SetOptionRequestDto {
    private int Gender;
    private Date Birth;
    private double Height;
    private double Weight;
    private int ActiveCoef;
}
