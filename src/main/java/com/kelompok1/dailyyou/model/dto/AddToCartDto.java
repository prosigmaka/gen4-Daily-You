package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    private Integer id;
    private Integer idProduct;
    private Integer productQuantity;
    private Long idUser;
}
