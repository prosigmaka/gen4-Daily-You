package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Product;
import lombok.Data;


@Data
public class CartDto {
    private Integer id;
    private Integer idUser;
    private Integer idProduct;
    private String productName;
    private Integer productQuantity;
    private Product product;
    private Double totalPrice;
}