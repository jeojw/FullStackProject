package com.example.demo.Diet;

import com.example.demo.BodyInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping("/api/getDietList")
    public ResponseEntity<CompletableFuture<List<DietDto>>> getDietList(@RequestParam("userEmail") String userEmail){
        return ResponseEntity.ok(dietService.getDietList(userEmail));
    }

    @PostMapping("/api/searchDietListByOption")
    public ResponseEntity<CompletableFuture<List<DietDto>>> searchDietListByOption(@RequestBody @Validated SearchDto searchDto){
        return ResponseEntity.ok(dietService.searchDietListByOption(searchDto));
    }

    @PostMapping("/api/searchDietList")
    public ResponseEntity<CompletableFuture<List<DietDto>>> searchDietList(@RequestBody @Validated BodyInfoDto bodyInfoDto){
        return ResponseEntity.ok(dietService.searchDietList(bodyInfoDto.getUserEmail(), bodyInfoDto.getBMR(), bodyInfoDto.getActiveCoef()));
    }

    @PostMapping("/api/sortDietList")
    public ResponseEntity<CompletableFuture<List<DietDto>>> sortDietList(@RequestBody @Validated SortDietRequestDto sortDietRequestDto){
        return ResponseEntity.ok(dietService.sortDietList(sortDietRequestDto.getDietList(),
                sortDietRequestDto.getNutrient(),
                sortDietRequestDto.getSortOption()));
    }

    @GetMapping("/api/dietInfo/{id}")
    public ResponseEntity<CompletableFuture<DietDto>> getDiet(@PathVariable Long id){
        return ResponseEntity.ok(dietService.getDiet(id));
    }
}
