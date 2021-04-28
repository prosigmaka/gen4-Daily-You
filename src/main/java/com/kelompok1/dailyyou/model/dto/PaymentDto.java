package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private Integer id;
    private Integer idCustomer;
    private Integer tanggalUpload;
    private String file;
    private String statusPembayaran;

}