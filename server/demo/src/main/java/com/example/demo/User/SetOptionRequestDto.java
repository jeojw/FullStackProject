package com.example.demo.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class SetOptionRequestDto {
    private String userEmail;
    private int gender;
    private Date birth;
    private double height;
    private double weight;
    private int activeCoef;
}
