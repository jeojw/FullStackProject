package com.example.demo.Diet.DietSideDish;

import com.example.demo.Diet.DietDto;
import com.example.demo.Diet.SideDish.SideDishDto;
import com.example.demo.User.UserDto;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietSideDishDto {
    private SideDishDto sideDishDto;

    public static DietSideDishDto toDietSideDishDto(DietSideDishEntity dietSideDishEntity){
        return DietSideDishDto.builder()
                .sideDishDto(SideDishDto.toSideDishDto(dietSideDishEntity.getSideDish()))
                .build();
    }
}
