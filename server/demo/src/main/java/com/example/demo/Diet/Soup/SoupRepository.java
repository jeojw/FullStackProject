package com.example.demo.Diet.Soup;

import com.example.demo.Diet.Rice.RiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SoupRepository extends JpaRepository<SoupEntity, Long> {

}
