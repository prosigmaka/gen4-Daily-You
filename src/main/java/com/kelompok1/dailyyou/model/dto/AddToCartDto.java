package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    private Integer id;
    private Integer productId;
    private Integer productQuantity;

}
