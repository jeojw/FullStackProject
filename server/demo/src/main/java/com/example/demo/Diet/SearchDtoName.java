package com.example.demo.Diet;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDtoName {
    private String userEmail;
    private String searchRice;
    private String searchSoup;
    private String searchSideDish;
}
