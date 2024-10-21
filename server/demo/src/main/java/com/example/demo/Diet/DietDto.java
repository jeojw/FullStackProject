package com.example.demo.Diet;

import com.example.demo.Diet.Rice.RiceDto;
import com.example.demo.Diet.SideDish.SideDishDto;
import com.example.demo.Diet.Soup.SoupDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DietDto {
    private Long Id;
    private RiceDto Rice;
    private SoupDto Soup;
    private List<SideDishDto> SideDishList;

    private double Calorie;
    private double Carbohydrate;
    private double Protein;
    private double Province;

    public DietDto(Long id, RiceDto rice, SoupDto soup, List<SideDishDto> sideDishDtoList)
    {
        this.Id = id;
        this.Rice = rice;
        this.Soup = soup;
        this.SideDishList = sideDishDtoList;

        this.Calorie = rice.getCalorie() + soup.getCalorie() + sideDishDtoList.stream().mapToDouble(SideDishDto::getCalorie).sum();
        this.Carbohydrate = rice.getCarbohydrate() + soup.getCarbohydrate() + sideDishDtoList.stream().mapToDouble(SideDishDto::getCarbohydrate).sum();
        this.Protein = rice.getProtein() + soup.getProtein() + sideDishDtoList.stream().mapToDouble(SideDishDto::getProtein).sum();
        this.Province = rice.getProvince() + soup.getProvince() + sideDishDtoList.stream().mapToDouble(SideDishDto::getProvince).sum();
    }
}
