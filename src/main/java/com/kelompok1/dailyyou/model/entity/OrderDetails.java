package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = OrderDetails.TABLE_NAME)
@Data
public class OrderDetails {
    public static final String TABLE_NAME = "order_details";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "order_details_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tanggal_ci", nullable = false)
    private Date tanggalCi;
    @Column(name = "penerima", nullable = false)
    private String penerima;
    @Column(name = "alamat_kirim", nullable = false)
    private String alamatKirim;
    @Column(name="total_harga_ci", nullable = false)
    private Double totalHargalCi;
    @Column(name="tipe_pembayaran", nullable = false)
    private String tipePembayaran;

    @Enumerated(EnumType.STRING)
    @Column(name="status_pesanan", nullable = false)
    private OrderStatus orderStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="batas_tanggal_pembayaran", nullable = false)
    private Date batasTanggalPembayaran;

//    @ManyToOne
//    @JoinColumn(name = "id_user", updatable = false, insertable = false)
//    private User user;
//    @Column(name="id_user", nullable = false)
//    private Integer idUser;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user", updatable = false, insertable = false)
    private List<OrderItems> items;


}