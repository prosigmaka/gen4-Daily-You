package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name= Product.TABLE_NAME)
@Data
public class Product {
    public static final String TABLE_NAME = "t_produk";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_produk_seq")

    @Column(name = "id_produk")
    private Integer id;

    private String namaProduk;

    private Integer stock;

    private Integer harga;

    @ManyToOne
    @JoinColumn(name = "id_kategori", insertable = false, updatable = false, nullable = false)
    private ProductCategory productCategory;

    @Column(name = "id_kategori_produk", nullable = false)
    private Integer idKategori;
}
