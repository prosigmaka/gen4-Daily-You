package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Cart.TABLE_NAME)
@Data
public class Cart {
    public static final String TABLE_NAME = "t_cart";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_cart_seq")
    private Integer id;

//    @Column(name = "created_date")
//    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private int productQuantity;

    public Cart() {
    }

    public Cart(Product product, int productQuantity, User user){
        this.user = user;
        this.product = product;
        this.productQuantity = productQuantity;
//        this.createdDate = new Date();
    }


//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
//    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_cart_seq")
//    @Column(name = "id_cart")
//    private Integer id;
//
//    @Column(name = "created_date")
//    private Date createdDate;
//
//    @JsonIgnore
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_user",  nullable = false)
//    private User user;
//
////    @Column(name = "id_user", nullable = false)
////    private Integer idUser;
//
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_product",  nullable = false)
//    Product product;
//
//    private Integer productQuantity;
//
////    private Double totalCost;

}