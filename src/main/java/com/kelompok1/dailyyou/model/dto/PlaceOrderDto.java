package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.Users;
import javax.validation.constraints.NotNull;

public class PlaceOrderDto {
    private Integer id;
    private @NotNull Users user;
    private @NotNull Double totalPrice;

    public PlaceOrderDto() {
    }

    public PlaceOrderDto(Order order) {
        this.setId(order.getId());
        this.setUser(order.getUser());
        this.setTotalPrice(order.getTotalPrice());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

