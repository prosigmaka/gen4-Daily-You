package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class ProdukDto {
    private Integer id;
    private String namaProduk;
    private Integer stock;
    private Integer harga;
    private Integer idKategori;
    private Integer namaKategori;

}
