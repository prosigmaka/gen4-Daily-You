package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kelompok1.dailyyou.model.dto.PlaceOrderDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= Order.TABLE_NAME)
@Data
public class Order extends CommonEntity{
    public static final String TABLE_NAME = "t_order";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_order_seq")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "order_id")
    private Integer id;


    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "total_cost")
    private Double totalCost;

//    @Column(name = "session_id")
//    private String sessionId;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
//
//    @ManyToOne()
//    @JsonIgnore
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

    public Order() {
    }

    public Order(PlaceOrderDto orderDto){
//        this.user = user;
        this.createdDate = new Date();
        this.totalCost = orderDto.getTotalPrice();
//        this.sessionId = sessionId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}

