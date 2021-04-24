package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= Delivery.TABLE_NAME)
@Data
public class Delivery {
    public static final String TABLE_NAME = "t_delivery";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_pdelivery_seq")

    @Column(name = "id_delivery")
    private Integer id;

    private String typeDelivery;

    @ManyToOne
    @JoinColumn(name = "id_address_category", insertable = false, updatable = false, nullable = false)
    private AddressCategory addressCategory;

    @Column(name = "id_address_category", nullable = false)
    private Integer idCategory;

}

