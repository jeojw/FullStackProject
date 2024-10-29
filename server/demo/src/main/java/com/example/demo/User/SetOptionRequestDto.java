package com.example.demo.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class SetOptionRequestDto {
    private String userEmail;
    private int gender;
    private LocalDate birth;
    private double height;
    private double weight;
    private int activeCoef;
}
