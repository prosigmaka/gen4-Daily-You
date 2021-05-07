package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.Users;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PlaceOrderDto {
    private Integer id;
    private @NotNull Users user;
    private @NotNull Double totalPrice;

}
