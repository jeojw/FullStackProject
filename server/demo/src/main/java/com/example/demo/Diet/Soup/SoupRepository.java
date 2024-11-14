package com.example.demo.Diet.Soup;

import com.example.demo.Diet.SideDish.SideDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SoupRepository extends JpaRepository<SoupEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.soup_table", nativeQuery = true)
    List<SoupEntity> getSoupEntityList();

    @Query(value = "SELECT * FROM fullstack_proj.soup_table WHERE name = :name", nativeQuery = true)
    SoupEntity getSoupEntity(@Param("name") String name);

    @Query(value = "SELECT id FROM fullstack_proj.soup_table WHERE LIKE %:name%", nativeQuery = true)
    Optional<List<Long>> getSoupEntityId(@Param("name") String name);
}
