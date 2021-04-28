package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= Order.TABLE_NAME)
@Data
public class Order extends com.kelompok1.dailyyou.model.entity.CommonEntity {
    public static final String TABLE_NAME = "t_transaction";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_transaction_seq")

    @Column(name = "id_transaction")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_detail", insertable = false, updatable = false, nullable = false)
    private com.kelompok1.dailyyou.model.entity.OrderDetails orderDetails;

    @Column (name = "id_detail", nullable = false)
    private Integer idDetail;

    private Double totalPriceOrder;

    private String orderStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="payment_deadline")
    private Date paymentDeadline;
}

