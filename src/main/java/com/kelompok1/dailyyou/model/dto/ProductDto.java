package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String productName;
    private Integer stock;
    private Double price;
    private String pictureUrl;
    private Integer idCategory;
    private Integer categoryName;

}