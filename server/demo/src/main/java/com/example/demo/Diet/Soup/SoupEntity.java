package com.example.demo.Diet.Soup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SoupTable")
public class SoupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double calorie;

    @Column(nullable = false)
    private double carbohydrate;

    @Column(nullable = false)
    private double protein;

    @Column(nullable = false)
    private double province;
}
