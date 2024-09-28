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
    private String Name;

    @Column(nullable = false)
    private int Calorie;

    @Column(nullable = false)
    private int Carbohydrate;

    @Column(nullable = false)
    private int Protein;

    @Column(nullable = false)
    private int Province;
}
