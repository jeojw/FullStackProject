package com.example.demo.Diet;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping("/api/searchDietList")
    public ResponseEntity<Page<DietDto>> getDietList(int page, int carbohydrate, int protein, int province){
        return ResponseEntity.ok(dietService.getDietList(page, carbohydrate, protein, province));
    }
}
