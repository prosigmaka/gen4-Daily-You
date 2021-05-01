package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer productQuantity;

    public AddToCartDto() {
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", productQuantity=" + productQuantity +
                ",";
    }

}
