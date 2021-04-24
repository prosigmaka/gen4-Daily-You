package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name= Product.TABLE_NAME)
@Data
public class Product {
    public static final String TABLE_NAME = "t_product";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_product_seq")

    @Column(name = "id_product")
    private Integer id;

    private String productName;

    private Integer stock;

    private Double price;

    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false, nullable = false)
    private ProductCategory productCategory;

    @Column(name = "id_product_category", nullable = false)
    private Integer idCategory;
}

