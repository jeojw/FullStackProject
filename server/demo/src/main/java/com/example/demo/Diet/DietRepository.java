package com.example.demo.Diet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DietRepository extends JpaRepository<DietEntity, Integer> {
    @Query(value = "SELECT * FROM fullstack_proj.diet_list WHERE carbohydrate BETWEEN :minCar AND :maxCar, " +
            "protein BETWEEN :minProtein AND :maxProtein, BETWEEN :minProvince AND :maxProvince",
    nativeQuery = true)
    Page<DietEntity> returnSearchDiets(Pageable pageable, @Param("minCar") int min_carbohydrate, @Param("maxCar") int max_carbohydrate,
                                       @Param("minProtein") int min_protein, @Param("maxProtein") int max_protein,
                                       @Param("minProvince") int min_province, @Param("maxProvince") int max_province);
}
