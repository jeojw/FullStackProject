package com.example.demo.Diet;

import com.example.demo.Diet.Rice.RiceEntity;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.Diet.Soup.SoupEntity;
import com.example.demo.User.UserEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "dietEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SideDishEntity> sideDish;

    @Column(nullable = false)
    private double Calorie;

    @Column(nullable = false)
    private double Carbohydrate;

    @Column(nullable = false)
    private double Protein;

    @Column(nullable = false)
    private double Province;

    public DietEntity(RiceEntity rice, SoupEntity soup, List<SideDishEntity> sideDishDtoList, UserEntity user)
    {
        this.rice = rice;
        this.soup = soup;
        this.sideDish = sideDishDtoList;
        this.user = user;

        this.Calorie = rice.getCalorie() + soup.getCalorie() + sideDishDtoList.stream().mapToDouble(SideDishEntity::getCalorie).sum();
        this.Carbohydrate = rice.getCarbohydrate() + soup.getCarbohydrate() + sideDishDtoList.stream().mapToDouble(SideDishEntity::getCarbohydrate).sum();
        this.Protein = rice.getProtein() + soup.getProtein() + sideDishDtoList.stream().mapToDouble(SideDishEntity::getProtein).sum();
        this.Province = rice.getProvince() + soup.getProvince() + sideDishDtoList.stream().mapToDouble(SideDishEntity::getProvince).sum();
    }
}
