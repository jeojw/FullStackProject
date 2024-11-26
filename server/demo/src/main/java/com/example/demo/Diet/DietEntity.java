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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="rice_table_id")
    private RiceEntity rice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="soup_table_id")
    private SoupEntity soup;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
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
    }

    public void setCalorie(){
        this.calorie = rice.getCalorie() * 1.5 + soup.getCalorie() * 1.5 + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> {
                    String classification = dietSideDish.getSideDish().getClassification();
                    if (classification.equals("구이류") || classification.equals("찜류") || classification.equals("전·적 및 부침류")) {
                        return dietSideDish.getSideDish().getCalorie();
                    } else {
                        return dietSideDish.getSideDish().getCalorie() * 0.5;
                    }
                })
                .sum();
    }

    public void setCarbohydrate(){
        this.carbohydrate = rice.getCarbohydrate() * 1.5 + soup.getCarbohydrate() * 1.5 + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> {
                    String classification = dietSideDish.getSideDish().getClassification();
                    if (classification.equals("구이류") || classification.equals("찜류") || classification.equals("전·적 및 부침류")) {
                        return dietSideDish.getSideDish().getCarbohydrate();
                    } else {
                        return dietSideDish.getSideDish().getCarbohydrate() * 0.5;
                    }
                })
                .sum();
    }

    public void setProtein(){
        this.protein = rice.getProtein() * 1.5 + soup.getProtein() * 1.5 + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> {
                    String classification = dietSideDish.getSideDish().getClassification();
                    if (classification.equals("구이류") || classification.equals("찜류") || classification.equals("전·적 및 부침류")) {
                        return dietSideDish.getSideDish().getProtein();
                    } else {
                        return dietSideDish.getSideDish().getProtein() * 0.5;
                    }
                })
                .sum();
    }

    public void setProvince(){
        this.province = rice.getProvince() * 1.5 + soup.getProvince() * 1.5 + dietSideDishes.stream()
                .mapToDouble(dietSideDish -> {
                    String classification = dietSideDish.getSideDish().getClassification();
                    if (classification.equals("구이류") || classification.equals("찜류") || classification.equals("전·적 및 부침류")) {
                        return dietSideDish.getSideDish().getProvince();
                    } else {
                        return dietSideDish.getSideDish().getProvince() * 0.5;
                    }
                })
                .sum();
    }

    public void addDietSideDish(DietSideDishEntity dietSideDish) {
        dietSideDish.setDiet(this);
        this.dietSideDishes.add(dietSideDish);
    }
}
