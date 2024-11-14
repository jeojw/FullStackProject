package com.example.demo.Diet.SideDish;

import com.example.demo.Diet.Rice.RiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SideDishRepository extends JpaRepository<SideDishEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.side_dish_table WHERE classification = '찜류'" +
            "or classification = '구이류' or classification = '전·적 및 부침류'", nativeQuery = true)
    List<SideDishEntity> getSideDishEntityList_1();

    @Query(value = "SELECT * FROM fullstack_proj.side_dish_table WHERE classification = '볶음류'" +
            "or classification = '조림류' or classification = '튀김류'", nativeQuery = true)
    List<SideDishEntity> getSideDishEntityList_2();

    @Query(value = "SELECT * FROM fullstack_proj.side_dish_table WHERE classification = '나물·숙채류'" +
            "or classification = '생채·무침류' or classification = '김치류' or classification = '젓갈류'" +
            "or classification = '장아찌·절임류'", nativeQuery = true)
    List<SideDishEntity> getSideDishEntityList_3();

    @Query(value = "SELECT * FROM fullstack_proj.side_dish_table WHERE name = :name", nativeQuery = true)
    SideDishEntity getSideDishEntity(@Param("name") String name);

    @Query(value = "SELECT id FROM fullstack_proj.side_dish_table WHERE LIKE %:name%", nativeQuery = true)
    Optional<List<Long>> getSideDishEntityId(@Param("name") String name);
}
