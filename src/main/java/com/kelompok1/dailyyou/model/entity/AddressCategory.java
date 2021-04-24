package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= AddressCategory.TABLE_NAME)
@Data
public class AddressCategory {
    public static final String TABLE_NAME = "t_kategori_alamat";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_kategori_alamat_seq")

    @Column(name = "id_kategori_alamat")
    private Integer idKategoriAlamat;

    private String namaAlamat;

    private Double hargaKirim;

}

