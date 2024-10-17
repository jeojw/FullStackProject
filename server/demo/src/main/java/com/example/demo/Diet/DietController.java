package com.example.demo.Diet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping("/api/searchDietList")
    public ResponseEntity<List<DietDto>> getDietList(double BMR, double activeCoef){
        return ResponseEntity.ok(dietService.getDietList(BMR, activeCoef));
    }
}
