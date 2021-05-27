package com.kelompok1.dailyyou.model.dto;


import lombok.Data;

@Data
public class CheckoutDto {
    private String productName;
    private Integer  productQuantity;
    private Double price;
    private Integer productId;
    private int userId;

//    public CheckoutDto() {}
//
//    public CheckoutDto(String productName, Integer productQuantity, Double price, Integer productId) {
//        this.productName = productName;
//        this.productQuantity = productQuantity;
//        this.price = price;
//        this.productId = productId;
//        this.userId = userId;
//    }
}
