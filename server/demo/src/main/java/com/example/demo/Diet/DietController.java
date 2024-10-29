package com.example.demo.Diet;

import com.example.demo.BodyInfoDto;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping("/api/getDietList")
    public ResponseEntity<List<DietDto>> getDietList(@Param("userEMail") String userEmail){
        return ResponseEntity.ok(dietService.getDietList(userEmail));
    }

    @PostMapping("/api/searchDietList")
    public ResponseEntity<List<DietDto>> searchDietList(@RequestBody @Validated BodyInfoDto bodyInfoDto){
        return ResponseEntity.ok(dietService.searchDietList(bodyInfoDto.getUserEmail(), bodyInfoDto.getBMR(), bodyInfoDto.getActiveCoef()));
    }

    @GetMapping("/api/sortDietList")
    public ResponseEntity<List<DietDto>> sortDietList(@RequestBody @Validated SortDietRequestDto sortDietRequestDto){
        return ResponseEntity.ok(dietService.sortDietList(sortDietRequestDto.getDietList(),
                sortDietRequestDto.getNutrient(),
                sortDietRequestDto.getSortOption()));
    }

    @GetMapping("/api/dietInfo/{id}")
    public ResponseEntity<DietDto> getDiet(@PathVariable Long id){
        return ResponseEntity.ok(dietService.getDiet(id));
    }
}
