package com.example.demo.Diet;

import com.example.demo.Diet.Rice.RiceEntity;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.Diet.Soup.SoupEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DietList")
public class DietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="rice_table")
    private RiceEntity rice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="soup_table")
    private SoupEntity soup;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="side_dish_table")
    private SideDishEntity sideDish;

    @Column(nullable = false)
    private int Calorie;

    @Column(nullable = false)
    private int Carbohydrate;

    @Column(nullable = false)
    private int Protein;

    @Column(nullable = false)
    private int Province;
}
