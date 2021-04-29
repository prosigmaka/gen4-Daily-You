package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.kelompok1.dailyyou.model.dto.PlaceOrderDto;

//@Entity
//@Table(name= Order.TABLE_NAME)
//@Data
//public class Order extends com.kelompok1.dailyyou.model.entity.CommonEntity {
//    public static final String TABLE_NAME = "t_order";
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
//    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_order_seq")
//
//    @Column(name = "id_order")
//    private Integer id;
//
//    @OneToOne
//    @JoinColumn(name = "id_detail", insertable = false, updatable = false, nullable = false)
//    private OrderDetails orderDetails;
//
//    @Column (name = "id_detail", nullable = false)
//    private Integer idDetail;
//
//    private Double totalPriceOrder;
//
//    private String orderStatus;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="payment_deadline")
//    private Date paymentDeadline;
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//
//    @Column(name = "created_date")
//    private Date createdDate;
//
//    @Column(name = "total_price")
//    private Double totalPrice;
//
//    @Column(name = "session_id")
//    private String sessionId;
//
//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//    private List<OrderItem> orderItems;
//
//    @ManyToOne()
//    @JsonIgnore
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    public Order() {
//    }
//
//    public Order(PlaceOrderDto orderDto, User user, String sessionId){
//        this.user = user;
//        this.createdDate = new Date();
//        this.totalPrice = orderDto.getTotalPrice();
//        this.sessionId = sessionId;
//    }
//
//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(Double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    public String getSessionId() {
//        return sessionId;
//    }
//
//    public void setSessionId(String sessionId) {
//        this.sessionId = sessionId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
//

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "session_id")
    private String sessionId;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    public Order() {
    }

    public Order(PlaceOrderDto orderDto, Users user, String sessionId){
        this.user = user;
        this.createdDate = new Date();
        this.totalPrice = orderDto.getTotalPrice();
        this.sessionId = sessionId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
