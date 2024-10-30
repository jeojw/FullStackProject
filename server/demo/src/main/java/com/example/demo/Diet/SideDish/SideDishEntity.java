package com.example.demo.Diet.SideDish;

import com.example.demo.Diet.DietSideDish.DietSideDishEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SideDishTable")
public class SideDishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String classification;

    @Column(nullable = false)
    private double calorie;

    @Column(nullable = false)
    private double carbohydrate;

    @Column(nullable = false)
    private double protein;

    @Column(nullable = false)
    private double province;

    @OneToMany(mappedBy = "sideDish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietSideDishEntity> dietSideDishes;
}
