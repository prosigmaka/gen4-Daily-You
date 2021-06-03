package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = OrderItems.TABLE_NAME)
@Data
public class OrderItems {
    public static final String TABLE_NAME = "order_items";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "order-items_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_cart", updatable = false, insertable = false)
    private Cart cart;
    @Column(name="id_cart", nullable = false)
    private Integer idCart;

//    @ManyToOne
//    @JoinColumn(name = "id_user", updatable = false, insertable = false)
//    private User user;
//    @Column(name="id_user", nullable = false)
//    private Integer idUser;

}
