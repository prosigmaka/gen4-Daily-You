package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= Cart.TABLE_NAME)
@Data
public class Cart {
    public static final String TABLE_NAME = "t_keranjang";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_keranjang_seq")
    @Column(name = "id_keranjang")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false, nullable = false)
    private Product product;

    @Column(name = "id_produk",nullable = false)
    private Integer idProduk;

    private Integer jumlahProduk;

    private Integer totalHarga;
}
