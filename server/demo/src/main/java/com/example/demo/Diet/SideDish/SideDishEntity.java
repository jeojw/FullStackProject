package com.example.demo.Diet.SideDish;

import com.example.demo.Diet.DietEntity;
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
@Table(name = "SideDishTable")
public class SideDishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Classification;

    @Column(nullable = false)
    private double Calorie;

    @Column(nullable = false)
    private double Carbohydrate;

    @Column(nullable = false)
    private double Protein;

    @Column(nullable = false)
    private double Province;

    @ManyToOne
    @JoinColumn(name = "diet_list_id")
    private DietEntity dietEntity;
}
