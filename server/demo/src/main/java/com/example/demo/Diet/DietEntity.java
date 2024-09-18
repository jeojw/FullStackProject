package com.example.demo.Diet;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String Name;

    @Column(nullable = false)
    private int Calorie;

    @Column(nullable = false)
    private int Carbohydrate;

    @Column(nullable = false)
    private int Protein;

    @Column(nullable = false)
    private int Province;

    @Column(nullable = false)
    private String RecipeLink;
}
