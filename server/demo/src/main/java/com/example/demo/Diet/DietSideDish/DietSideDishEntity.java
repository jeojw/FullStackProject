package com.example.demo.Diet.DietSideDish;

import com.example.demo.Diet.DietEntity;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "diet_side_dish")
public class DietSideDishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private DietEntity diet;

    @ManyToOne
    @JoinColumn(name = "side_dish_id")
    private SideDishEntity sideDish;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
