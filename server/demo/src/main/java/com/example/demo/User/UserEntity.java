package com.example.demo.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String UserEmail;

    @Column(nullable = false)
    private String UserPassword;

    @Column(nullable = false)
    private int Calorie;

    @Column(nullable = false)
    private int Carbohydrate;

    @Column(nullable = false)
    private int Protein;

    @Column(nullable = false)
    private int Province;
}
