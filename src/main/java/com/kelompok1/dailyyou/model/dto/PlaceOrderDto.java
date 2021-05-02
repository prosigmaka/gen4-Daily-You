package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.User;
import lombok.Data;



@Data
public class PlaceOrderDto {
    private Integer id;
    private  User user;
    private  Double totalPrice;

    public PlaceOrderDto() {
    }

    public PlaceOrderDto(Order order) {
        this.setId(order.getId());
        this.setUser(order.getUser());
        this.setTotalPrice(order.getTotalCost());
    }
}
