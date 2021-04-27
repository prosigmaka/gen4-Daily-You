package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Product;
import lombok.Data;

import java.util.List;


@Data
public class CartDto {
    private Integer IdCart;
    private List<CartItemDto> cartItems;
    private double totalCost;

    public CartDto(List<CartItemDto> cartItemDtoList, double totalCost) {
        this.cartItems = cartItemDtoList;
        this.totalCost = totalCost;
    }
//    private Integer id;
//    private Integer idProduct;
//    private Integer userId;
//    private Integer productQuantity;
//    private Product product;
//    private Double totalPrice;


    //    private Integer idUser;
//    private Integer idProduct;
//    private String productName;
//    private Integer productQuantity;
//    private Product product;
//    private Double totalPrice;

}

