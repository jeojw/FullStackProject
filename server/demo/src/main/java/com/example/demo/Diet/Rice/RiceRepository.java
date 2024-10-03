package com.example.demo.Diet.Rice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RiceRepository extends JpaRepository<RiceEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.rice_table  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<RiceEntity> getRiceEntity();
}
