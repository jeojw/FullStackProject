package com.example.demo.User;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class UserDto {
    private String UserEmail;
    private String UserPassword;
    private int Gender;
    private Date Birth;
    private int age;
    private double Height;
    private double Weight;
    private double BMR;
    private int ActiveCoef;

    public UserDto(String userEmail, String userPassword, int gender, Date birth, double height, double weight, int activeCoef)
    {
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.Gender = gender;
        this.Birth = birth;
        this.Height = height;
        this.Weight = weight;
        this.ActiveCoef = activeCoef;
        this.age = Period.between(Birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();

        if (gender == 1) {
            this.BMR = 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * this.age);
        }
        else {
            this.BMR = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * this.age);
        }
    }
}
