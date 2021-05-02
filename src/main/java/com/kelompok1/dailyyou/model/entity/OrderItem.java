package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@Entity
@Table(name = OrderItem.TABLE_NAME)

public class OrderItem {
    public static final String TABLE_NAME = "t_order_item";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_order_item_seq")
    @Column(name = "id_order_item")
    private Integer id;

    @Column(name = "product_quantity")
    private  Integer productQuantity;

    @Column(name = "price")
    private  Double price;


    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Order order,  Product product,  int productQuantity,  double price) {
        this.product = product;
        this.productQuantity = productQuantity;
        this.price = price;
        this.order = order;
        this.createdDate = new Date();
    }
}