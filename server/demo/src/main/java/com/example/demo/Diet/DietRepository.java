package com.example.demo.Diet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DietRepository extends JpaRepository<DietEntity, Integer> {
    @Query(value = "SELECT * FROM fullstack_proj.diet_list WHERE user_id = :userId",
    nativeQuery = true)
    List<DietEntity> returnSearchDiets(@Param("userId") Long userId);

    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 0;", nativeQuery = true)
    @Transactional
    void disableForeignKeyChecks();

    @Modifying
    @Query(value = "DELETE FROM fullstack_proj.diet_list WHERE user_id = :userId;", nativeQuery = true)
    @Transactional
    void deleteDietListById(@Param("userId") Long id);

    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 1;", nativeQuery = true)
    @Transactional
    void enableForeignKeyChecks();

    default void deleteDietList(Long id) {
        disableForeignKeyChecks();
        deleteDietListById(id);
        enableForeignKeyChecks();
    }

    boolean existsByCarbohydrateAndProteinAndProvinceAndUserId(double carbohydrate, double protein, double province, Long userId);

    @Query(value = """
        SELECT d.id AS dietId, ds.id AS sideDishId, d.*
        FROM diet_list d
        JOIN diet_side_dish ds ON d.id = ds.diet_id
        WHERE d.user_id = :userId
          AND (d.rice_table_id IN (:riceIdList))
          AND (d.soup_table_id IN (:soupIdList))
          AND (ds.side_dish_id IN (:sideDishIdList))
    """, nativeQuery = true)
    List<DietEntity> searchDietListByOptions(
            @Param("userId") Long userId,
            @Param("riceIdList") List<Long> riceIdList,
            @Param("soupIdList") List<Long> soupIdList,
            @Param("sideDishIdList") List<Long> sideDishIdList
    );
}
