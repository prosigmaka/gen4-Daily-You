package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Order;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDto {
    private Integer id;
    private @NotNull Integer userId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
        //this.setUserId(order.getUserId());
    }
//    private Integer idTransaction;
//    private Integer idProduct;
//    private Integer productQuantity;
//    private Double totalPrice;
//    private Double totalPricePayment;
//    private Integer idPayment;
//    private Integer idCustomer;
//    private Integer idAddress;

}