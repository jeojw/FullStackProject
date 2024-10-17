package com.example.demo.Diet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietRepository extends JpaRepository<DietEntity, Integer> {
    @Query(value = "SELECT * FROM fullstack_proj.diet_list WHERE carbohydrate BETWEEN :minCar AND :maxCar, " +
            "protein BETWEEN :minProtein AND :maxProtein, BETWEEN :minProvince AND :maxProvince",
    nativeQuery = true)
    List<DietEntity> returnSearchDiets(@Param("minCar") double min_carbohydrate, @Param("maxCar") double max_carbohydrate,
                                       @Param("minProtein") double min_protein, @Param("maxProtein") double max_protein,
                                       @Param("minProvince") double min_province, @Param("maxProvince") double max_province);
}
