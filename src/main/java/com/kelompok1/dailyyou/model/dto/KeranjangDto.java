package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class KeranjangDto {
    private Integer id;
    private Integer jumlahProduk;
    private Integer totalHarga;
    private Integer idProduk;
    private String namaProduk;
    private Integer idCustomer;
}
