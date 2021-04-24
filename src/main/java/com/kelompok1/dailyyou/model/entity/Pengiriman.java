package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name=Pengiriman.TABLE_NAME)
@Data
public class Pengiriman {
    public static final String TABLE_NAME = "t_pengiriman";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_pengiriman_seq")

    @Column(name = "id_pengiriman")
    private Integer idPengiriman;

    private String jenisPengiriman;

    @ManyToOne
    @JoinColumn(name = "id_kategori_alamat", insertable = false, updatable = false, nullable = false)
    private KategoriAlamat kategoriAlamat;

    @Column(name = "id_kategori_alamat", nullable = false)
    private Integer idKategoriAlamat;

}

