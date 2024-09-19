package com.example.demo.User;

import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.user_info WHERE user_email = :userEmail AND user_password = :userPassword",
    nativeQuery = true)
    Optional<UserEntity> checkUser(@Param("userEmail") String email, @Param("userPassword") String password);

    @Query(value = "UPDATE fullstack_proj.user_info SET carbohydrate = :carbohydrate, protein = :protein, province = :province WHERE user_email = :userEmail",
    nativeQuery = true)
    @Transactional
    void setNutrient(@Param("carbohydrate") int carbohydrate, @Param("protein") int protein, @Param("province") int province, @Param("userEmail") String userEmail);
}
