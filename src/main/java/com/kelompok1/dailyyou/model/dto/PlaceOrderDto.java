package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Order;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PlaceOrderDto {
    private Integer id;
//    private @NotNull User user;
    private @NotNull Double totalPrice;

    public PlaceOrderDto() {
    }

    public PlaceOrderDto(Order order) {
        this.setId(order.getId());
//        this.setUser(order.getUser());
        this.setTotalPrice(order.getTotalCost());
    }
}
