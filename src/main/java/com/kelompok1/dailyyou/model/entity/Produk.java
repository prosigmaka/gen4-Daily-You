package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name=Produk.TABLE_NAME)
@Data
public class Produk {
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
    private KategoriProduk kategoriProduk;

    @Column(name = "id_kategori_produk", nullable = false)
    private Integer idKategori;
}
