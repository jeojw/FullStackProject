package com.example.demo.Diet.DietSideDish;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietSideDishRepository extends JpaRepository<DietSideDishEntity, Long> {
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 0;", nativeQuery = true)
    @Transactional
    void disableForeignKeyChecks();

    @Modifying
    @Query(value = "DELETE FROM fullstack_proj.diet_side_dish WHERE user_id = :userId;", nativeQuery = true)
    @Transactional
    void deleteDietListById(@Param("userId") Long id);

    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 1;", nativeQuery = true)
    @Transactional
    void enableForeignKeyChecks();

    default void deleteDietSideList(Long id) {
        disableForeignKeyChecks();
        deleteDietListById(id);
        enableForeignKeyChecks();
    }
}
