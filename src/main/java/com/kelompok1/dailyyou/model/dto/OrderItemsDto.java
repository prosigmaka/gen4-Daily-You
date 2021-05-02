package com.kelompok1.dailyyou.model.dto;

import lombok.Data;



@Data
public class OrderItemsDto {
    private  Double price;
    private  Integer productQuantity;
    private  Integer orderId;
    private  Integer productId;

    public OrderItemsDto () {}

    public OrderItemsDto( double price,  int productQuantity,  int orderId,  int productId) {
        this.price = price;
        this.productQuantity = productQuantity;
        this.orderId = orderId;
        this.productId = productId;
    }
}
