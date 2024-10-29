package com.example.demo.User;

import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM fullstack_proj.user_info WHERE user_email = :userEmail",
            nativeQuery = true)
    Optional<UserEntity> findByEmail(@Param("userEmail") String email);

    @Query(value = "UPDATE fullstack_proj.user_info SET user_password = :newPassword WHERE user_email = :userEmail",
            nativeQuery = true)
    @Modifying
    @Transactional
    void changePassword(@Param("userEmail") String userEmail,
                        @Param("newPassword") String newPassword);

    @Query(value = "UPDATE fullstack_proj.user_info SET height = :height, weight = :weight, " +
            "gender = :gender, birth =:birth, active_coef = :activeCoef, " +
            "age = :age, bmr = :bmr WHERE user_email = :userEmail",
    nativeQuery = true)
    @Modifying
    @Transactional
    void setOptions(@Param("userEmail") String userEmail,
                    @Param("height") double height, @Param("weight") double weight,
                    @Param("gender") int gender,
                    @Param("birth") LocalDate birth, @Param("age") int age,
                    @Param("bmr") double bmr, @Param("activeCoef") int activeCoef);
}
