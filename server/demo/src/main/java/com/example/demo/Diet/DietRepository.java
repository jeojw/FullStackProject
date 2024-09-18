package com.example.demo.Diet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<DietEntity, Long> {
}
