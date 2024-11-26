package com.example.demo.User;

import com.example.demo.Diet.DietDto;
import com.example.demo.Diet.DietEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userEmail;
    private String userPassword;
    private int gender;
    private LocalDate birth;
    private int age;
    private double height;
    private double weight;
    private double BMR;
    private int activeCoef;
    private List<DietDto> dietList;
    @Transactional
    public static UserDto toUserDto(UserEntity userEntity){
        List<DietDto> dtoList = new ArrayList<>();
        for (DietEntity entity : userEntity.getDietList()){
            dtoList.add(DietDto.toDietDto(entity));
        }
        return UserDto.builder()
                .userEmail(userEntity.getUserEmail())
                .userPassword(userEntity.getUserPassword())
                .gender(userEntity.getGender())
                .birth(userEntity.getBirth())
                .age(userEntity.getAge())
                .height(userEntity.getHeight())
                .weight(userEntity.getWeight())
                .BMR(userEntity.getBMR())
                .activeCoef(userEntity.getActiveCoef())
                .dietList(dtoList)
                .build();
    }

    @JsonCreator
    public UserDto(
            @JsonProperty("userEmail") String userEmail,
            @JsonProperty("userPassword") String userPassword,
            @JsonProperty("gender") int gender,
            @JsonProperty("birth") LocalDate birth,
            @JsonProperty("height") double height,
            @JsonProperty("weight") double weight,
            @JsonProperty("activeCoef") int activeCoef,
            @JsonProperty("dietList") List<DietDto> dietList) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.activeCoef = activeCoef;
        this.dietList = dietList;

        this.age = Period.between(birth, LocalDate.now()).getYears();
        if (gender == 0) {
            this.BMR = 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * this.age);
        } else {
            this.BMR = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * this.age);
        }
    }
}
