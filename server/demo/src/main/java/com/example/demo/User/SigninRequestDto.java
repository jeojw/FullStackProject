package com.example.demo.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SigninRequestDto {
    private String userEmail;
    private String userPassword;
}
