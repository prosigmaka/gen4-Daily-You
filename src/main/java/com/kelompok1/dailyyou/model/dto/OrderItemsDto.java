package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderItemsDto {
    private @NotNull Double price;
    private @NotNull Integer productQuantity;
    private @NotNull Integer orderId;
    private @NotNull Integer productId;

    public OrderItemsDto () {}

    public OrderItemsDto(@NotNull double price, @NotNull int productQuantity, @NotNull int orderId, @NotNull int productId) {
        this.price = price;
        this.productQuantity = productQuantity;
        this.orderId = orderId;
        this.productId = productId;
    }
}
