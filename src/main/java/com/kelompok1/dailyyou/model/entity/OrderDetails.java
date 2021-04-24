package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= OrderDetails.TABLE_NAME)
@Data
public class OrderDetails {
    public static final String TABLE_NAME = "t_detail";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_detail_seq")
    @Column(name = "id_detail")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_payment", insertable = false, updatable = false, nullable = false)
    private Delivery delivery;

    @Column(name = "id_payment",nullable = false)
    private Integer idPayment;

    @ManyToOne
    @JoinColumn(name = "id_cart", insertable = false, updatable = false, nullable = false)
    private Cart cart;

    @Column(name = "id_cart", nullable = false)
    private Integer idCart;

    private Integer productQuantity;

    private String orderStatus;

    private Double totalPricePayment;

    private String paymentDeadline;
}

