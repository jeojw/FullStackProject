package com.example.demo.User;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class UserDto {
    private String UserEmail;
    private String UserPassword;
    private double Weight;

    private double Carbohydrate;
    private double Protein;
    private double Province;

    private double DefaultCarbohydrate;
    private double DefaultProtein;
    private double DefaultProvince;

    public UserDto(String userEmail, String userPassword, double weight, double carbohydrate, double protein, double province)
    {
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.Weight = weight;

        this.Carbohydrate = carbohydrate;
        this.Protein = protein;
        this.Province = province;

        this.DefaultCarbohydrate = 34;
        this.DefaultProtein = weight * 0.8 / 3;
        this.DefaultProvince = weight / 3;
    }
}
