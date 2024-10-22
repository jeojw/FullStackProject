package com.example.demo.Diet;

import com.example.demo.BodyInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping("/api/searchDietList")
    public ResponseEntity<List<DietDto>> getDietList(@RequestBody @Validated BodyInfoDto bodyInfoDto){
        return ResponseEntity.ok(dietService.getDietList(bodyInfoDto.getBMR(), bodyInfoDto.getActiveCoef()));
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
