package com.example.demo.Diet;

import com.example.demo.Diet.Rice.RiceDto;
import com.example.demo.Diet.SideDish.SideDishDto;
import com.example.demo.Diet.Soup.SoupDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class DietDto {
    private RiceDto Rice;
    private SoupDto Soup;
    private SideDishDto SideDish_1;
    private SideDishDto SideDish_2;
    private SideDishDto SideDish_3;

    private int Calorie;
    private int Carbohydrate;
    private int Protein;
    private int Province;

    public DietDto(RiceDto rice, SoupDto soup, SideDishDto sideDish_1, SideDishDto sideDish_2, SideDishDto sideDish_3)
    {
        this.Rice = rice;
        this.Soup = soup;
        this.SideDish_1 = sideDish_1;
        this.SideDish_2 = sideDish_2;
        this.SideDish_3 = sideDish_3;

        this.Calorie = rice.getCalorie() + soup.getCalorie() + sideDish_1.getCalorie() + sideDish_2.getCalorie() + sideDish_3.getCalorie();
        this.Carbohydrate = rice.getCarbohydrate() + soup.getCarbohydrate() + sideDish_1.getCarbohydrate() + sideDish_2.getCarbohydrate() + sideDish_3.getCarbohydrate();
        this.Protein = rice.getProtein() + soup.getProtein() + sideDish_1.getProtein() + sideDish_2.getProtein() + sideDish_3.getProtein();
        this.Province = rice.getProvince() + soup.getProvince() + sideDish_1.getProvince() + sideDish_2.getProvince() + sideDish_3.getCarbohydrate();
    }
}
