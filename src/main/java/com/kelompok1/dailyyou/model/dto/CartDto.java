package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class CartDto {
    private Integer id;
    private Integer productQuantity;
    private Double totalPrice;
    private Integer idProduct;
    private String productName;
    private Integer idCustomer;
}