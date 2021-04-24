package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name=Pembayaran.TABLE_NAME)
@Data
public class Pembayaran {
    public static final String TABLE_NAME = "t_pembayaran";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_pembayaran_seq")

    @Column(name = "id_pembayaran")
    private Integer id;

    private String tanggalPembayaran;

    @Column(name = "bukti_url")
    private String file;
}

