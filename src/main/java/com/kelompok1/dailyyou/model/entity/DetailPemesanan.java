package com.kelompok1.dailyyou.model.entity;

import lombok.Data;
import org.thymeleaf.spring5.util.DetailedError;

import javax.persistence.*;

@Entity
@Table(name= DetailPemesanan.TABLE_NAME)
@Data
public class DetailPemesanan {
    public static final String TABLE_NAME = "t_detail";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_detail_seq")
    @Column(name = "id_detail")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pengiriman", insertable = false, updatable = false, nullable = false)
    private Pengiriman pengiriman;

    @Column(name = "id_pengiriman",nullable = false)
    private Integer idPengiriman;

    @ManyToOne
    @JoinColumn(name = "id_keranjang", insertable = false, updatable = false, nullable = false)
    private Keranjang keranjang;

    @Column(name = "id_keranjang", nullable = false)
    private Integer idKeranjang;

    private Integer jumlahProduk;

    private Double totalHargaPesanan;

    private String statusPembayaran;

    private Double totalHargaPembayaran;

    private String batasPembayaran;
}

