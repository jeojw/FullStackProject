package com.example.demo.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ChangePasswordDto {
    private String userEmail;
    private String newPassword;
}
