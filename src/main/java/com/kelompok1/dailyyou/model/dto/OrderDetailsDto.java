package com.kelompok1.dailyyou.model.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrderDetailsDto {
    private Integer id;
    private Date tanggalCi;
    private Integer tipePembayaran;
    private Double totalHargalCi;
    private Date batasTanggalPembayaran;
    private Enum statusPesanan;

    private List<OrderItemsDto> items;
}
