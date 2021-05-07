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

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

//    @JsonIgnore
//    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "user_id")
//    private Users user;

    private int productQuantity;


}
