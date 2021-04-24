package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= OrderDetails.TABLE_NAME)
@Data
public class OrderDetails {
    public static final String TABLE_NAME = "t_detail";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_detail_seq")
    @Column(name = "id_detail")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pengiriman", insertable = false, updatable = false, nullable = false)
    private Delivery delivery;

    @Column(name = "id_pengiriman",nullable = false)
    private Integer idPengiriman;

    @ManyToOne
    @JoinColumn(name = "id_keranjang", insertable = false, updatable = false, nullable = false)
    private Cart cart;

    @Column(name = "id_keranjang", nullable = false)
    private Integer idKeranjang;

    private Integer jumlahProduk;

    private Double totalHargaPesanan;

    private String statusPembayaran;

    private Double totalHargaPembayaran;

    private String batasPembayaran;
}

