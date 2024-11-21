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

    boolean existsByCarbohydrateAndProteinAndProvince(double Carbohydrate, double Protein, double Province);

    @Query(value = "SELECT * FROM fullstack_proj.diet_list WHERE rice_table_id IN :riceList and soup_table_id IN :soupList and user_id = :userId",
            nativeQuery = true)
    Optional<List<DietEntity>> searchDietList(@Param("userId") Long userId,
                                              @Param("riceList") List<Long> riceIdList,
                                              @Param("soupList") List<Long> soupIdList);
}
