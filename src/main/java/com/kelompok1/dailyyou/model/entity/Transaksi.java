package com.kelompok1.dailyyou.model.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name=Transaksi.TABLE_NAME)
@Data
public class Transaksi {
    public static final String TABLE_NAME = "t_transaksi";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_transaksi_seq")

    @Column(name = "id_transaksi")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pembayaran", insertable = false, updatable = false, nullable = false)
    private Pembayaran pembayaran;

    @Column(name = "id_pembayaran", nullable = false)
    private Integer idPembayaran;

    @OneToOne
    @JoinColumn(name = "id_detail", insertable = false, updatable = false, nullable = false)
    private DetailPemesanan detailPemesanan;

    @Column (name = "id_detail", nullable = false)
    private Integer idDetail;

    private Double totalHargaPesanan;

    private String statusPesanan;

    private Double totalHargaPembayaran;

    private String batasPembayaran;

}

