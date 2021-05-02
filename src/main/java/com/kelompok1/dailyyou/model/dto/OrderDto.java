package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Order;
import com.sun.istack.NotNull;
import lombok.Data;



@Data
public class OrderDto {
    private Integer id;
    private Integer userId;

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