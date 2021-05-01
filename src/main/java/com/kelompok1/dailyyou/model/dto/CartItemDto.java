package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class CartItemDto {
    private Integer id;
//    private @NotNull Integer userId;
    private @NotNull Integer productQuantity;
    private @NotNull Product product;

    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
//        this.setUserId(cart.getIdUser());
        this.setProductQuantity(cart.getProductQuantity());
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
//                ", userId=" + userId +
                ", productQuantity=" + productQuantity +
                ", productName=" + product.getProductName() +
                '}';
    }

}
