package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Product;
import lombok.Data;

import java.util.List;


@Data
public class CartDto {
    private Integer id;
    private Integer idProduct;
    private Long idUser;
    private Integer productQuantity;
    private String productName;
    private Double price;

    private Double subTotalPrice;
    private String pictureUrl;

}

