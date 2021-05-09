package com.kelompok1.dailyyou.model.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = OrderItems.TABLE_NAME)
@Data
public class OrderItems {
    public static final String TABLE_NAME = "t_orderitem";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_orderitem_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_cart", updatable = false, insertable = false)
    private Cart cart;

    @Column(name="id_cart", nullable = false)
    private Integer idCart;

}