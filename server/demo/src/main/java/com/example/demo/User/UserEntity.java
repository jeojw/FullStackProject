package com.example.demo.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserInfo")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String UserEmail;

    @Column(nullable = false)
    private String UserPassword;

    @Column(nullable = false)
    private int Gender;

    @Column(nullable = false)
    private Date Birth;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private double Height;

    @Column(nullable = false)
    private double Weight;

    @Column(nullable = false)
    private double BMR;

    @Column(nullable = false)
    private int ActiveCoef;
}
