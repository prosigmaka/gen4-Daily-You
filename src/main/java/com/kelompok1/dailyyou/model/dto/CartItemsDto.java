package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

import java.util.List;
@Data
public class CartItemsDto {
    private List<AddToCartDto> addToCart;
}
