package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class OrderDto {
    private Integer id;
    private Integer tipePayment;
    private Double totalCost;
    private Date batasPayment;
    private Enum statusPesanan;

    private List<OrderItemsDto> items;
}
