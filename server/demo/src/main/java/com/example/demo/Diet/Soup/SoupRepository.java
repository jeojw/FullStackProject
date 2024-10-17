package com.example.demo.Diet.Soup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoupRepository extends JpaRepository<SoupEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.soup_table", nativeQuery = true)
    List<SoupEntity> getSoupEntityList();
}
