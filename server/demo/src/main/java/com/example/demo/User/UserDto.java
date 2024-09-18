package com.example.demo.User;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class UserDto {
    private String UserEmail;

    private String UserPassword;

    private int Calorie;

    private int Carbohydrate;

    private int Protein;

    private int Province;

    public UserDto(String userEmail, String userPassword, int calorie,
                   int carbohydrate, int protein, int province)
    {
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.Calorie = calorie;
        this.Carbohydrate = carbohydrate;
        this.Protein = protein;
        this.Province = province;
    }
}
