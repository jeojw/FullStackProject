package com.example.demo.Diet.Rice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RiceRepository extends JpaRepository<RiceEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.rice_table", nativeQuery = true)
    List<RiceEntity> getRiceEntityList();

    @Query(value = "SELECT * FROM fullstack_proj.rice_table WHERE name = :name", nativeQuery = true)
    RiceEntity getRiceEntity(@Param("name") String name);

    @Query(value = "SELECT id FROM fullstack_proj.rice_table WHERE LIKE %:name%" , nativeQuery = true)
    Optional<List<Long>> getRiceEntityId(@Param("name") String name);
}
