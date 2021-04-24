package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class TransaksiDto {
    private Integer idTransaksi;
    private Integer idProduk;
    private Integer jumlahProduk;
    private Double totalHarga;
    private Double totalBayar;
    private Integer idPembayaran;
    private Integer idCustomer;
    private Integer idAlamat;

}