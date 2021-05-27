package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Order.TABLE_NAME)
@Data
public class Order {
    public static final String TABLE_NAME = "t_order";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_order_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", updatable = false, insertable = false)
    private User user;
    @Column(name="id_user", nullable = false)
    private Integer idUser;

    @Column(name="total_cost", nullable = false)
    private Double totalCost;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="batas_pembayaran", nullable = false)
    private Date batasPembayaran;



}