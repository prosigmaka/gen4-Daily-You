package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Product;

import lombok.Data;

@Data
public class CartItemDto {
    private Integer id;
    private Integer userId;
    private Integer productQuantity;
    private Product product;

    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setUserId(cart.getUser().getId());
        this.setProductQuantity(cart.getProductQuantity());
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", productQuantity=" + productQuantity +
                ", productName=" + product.getProductName() +
                '}';
    }

}
