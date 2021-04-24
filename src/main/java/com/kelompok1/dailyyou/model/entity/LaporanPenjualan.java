package com.kelompok1.dailyyou.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name=LaporanPenjualan.TABLE_NAME)
@Data

public class LaporanPenjualan {
    public static final String TABLE_NAME = "t_laporan";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_laporan_seq")
    @Column(name = "id_laporan")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false, nullable = false)
    private Produk produk;

    @Column(name = "id_produk",nullable = false)
    private Integer idProduk;

    @ManyToOne
    @JoinColumn(name = "id_transaksi", insertable = false, updatable = false, nullable = false)
    private Transaksi transaksi;

    @Column(name = "id_transaksi",nullable = false)
    private Integer idTransaksi;

    private Integer tanggalTransaksi;

    private String namaProduk;

    private Integer jumlahProduk;
}
