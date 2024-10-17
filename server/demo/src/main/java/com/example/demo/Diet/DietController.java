package com.example.demo.Diet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping("/api/searchDietList")
    public ResponseEntity<List<DietDto>> getDietList(@RequestParam("BMR") double BMR,
                                                     @RequestParam("activeCoef") double activeCoef){
        return ResponseEntity.ok(dietService.getDietList(BMR, activeCoef));
    }

    @PostMapping("/api/dietInfo/{id}")
    public ResponseEntity<DietDto> getDiet(@PathVariable Long id){
        return ResponseEntity.ok(dietService.getDiet(id));
    }
}
