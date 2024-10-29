package com.example.demo.Diet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Query(value = "TRUNCATE TABLE fullstack_proj.diet_list;", nativeQuery = true)
    @Transactional
    void truncateDietList();

    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 1;", nativeQuery = true)
    @Transactional
    void enableForeignKeyChecks();

    default void deleteDietList() {
        disableForeignKeyChecks();
        truncateDietList();
        enableForeignKeyChecks();
    }
}
