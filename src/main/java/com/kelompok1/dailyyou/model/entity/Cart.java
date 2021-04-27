package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Cart.TABLE_NAME)
@Data
public class Cart {
    public static final String TABLE_NAME = "t_cart";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_cart_seq")
    @Column(name = "id_cart")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private User user;

    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false, nullable = false)
    private Product product;

    @Column(name = "id_product",nullable = false)
    private Integer idProduct;

    private Integer productQuantity;

    private Double totalPrice;
}