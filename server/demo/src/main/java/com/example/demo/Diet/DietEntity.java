package com.example.demo.Diet;

import com.example.demo.Diet.DietSideDish.DietSideDishEntity;
import com.example.demo.Diet.Rice.RiceEntity;
import com.example.demo.Diet.Soup.SoupEntity;
import com.example.demo.User.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DietList")
public class DietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="rice_table_id")
    private RiceEntity rice;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="soup_table_id")
    private SoupEntity soup;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietSideDishEntity> dietSideDishes;

    @Column(nullable = false)
    private double calorie;

    @Column(nullable = false)
    private double carbohydrate;

    @Column(nullable = false)
    private double protein;

    @Column(nullable = false)
    private double province;

    public DietEntity(RiceEntity rice, SoupEntity soup, UserEntity user)
    {
        this.rice = rice;
        this.soup = soup;
        this.user = user;
        this.dietSideDishes = dietSideDishes != null ? dietSideDishes : new ArrayList<>();

        this.calorie = rice.getCalorie() + soup.getCalorie() + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDish().getCalorie())
                .sum();
        this.carbohydrate = rice.getCarbohydrate() + soup.getCarbohydrate() + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDish().getCarbohydrate())
                .sum();
        this.protein = rice.getProtein() + soup.getProtein() + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDish().getProtein())
                .sum();
        this.province = rice.getProvince() + soup.getProvince() + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> dietSideDish.getSideDish().getProvince())
                .sum();
    }

    public void addDietSideDish(DietSideDishEntity dietSideDish) {
        dietSideDish.setDiet(this);
        this.dietSideDishes.add(dietSideDish);
    }
}
