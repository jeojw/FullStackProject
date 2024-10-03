package com.example.demo.Diet;

import com.example.demo.Diet.Rice.RiceEntity;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.Diet.Soup.SoupEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="rice_table_id")
    private RiceEntity rice;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="soup_table_id")
    private SoupEntity soup;

    @OneToMany(mappedBy = "dietEntity", cascade = CascadeType.PERSIST)
    private List<SideDishEntity> sideDish;

    @Column(nullable = false)
    private double Calorie;

    @Column(nullable = false)
    private double Carbohydrate;

    @Column(nullable = false)
    private double Protein;

    @Column(nullable = false)
    private double Province;
}
