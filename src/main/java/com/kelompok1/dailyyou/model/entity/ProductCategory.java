package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= ProductCategory.TABLE_NAME)
@Data
public class ProductCategory {
    public static final String TABLE_NAME = "t_product_category";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_product_category_seq")

//    @Column(name = "id")
//    private Integer id;

    @Column(name = "id_category")
    private Integer id;

    private String categoryName;

}

