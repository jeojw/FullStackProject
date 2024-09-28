package com.example.demo.Diet;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DietService {

    private final DietRepository dietRepository;

    public Page<DietDto> getDietList(int page, int carbohydrate, int protein, int province){
        Pageable pageable = PageRequest.of(page, 10);
        Page<DietEntity> entityPage = dietRepository.returnSearchDiets(pageable, carbohydrate - 100, carbohydrate + 100,
                protein - 5, protein + 5, province - 5, province + 5);
        List<DietDto> dtoList = new ArrayList<>();
        for (DietEntity dietEntity : entityPage)
        {
            dtoList.add(DietDto.builder()
                    .Calorie(dietEntity.getCalorie())
                    .Carbohydrate(dietEntity.getCarbohydrate())
                    .Protein(dietEntity.getProtein())
                    .Province(dietEntity.getProvince())
                    .build());
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), dtoList.size());

        return new PageImpl<>(dtoList.subList(start, end), pageable, dtoList.size());
    }
}
