package com.kelompok1.dailyyou.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = AuthenticationToken.TABLE_NAME)
@Data
public class AuthenticationToken {
    public static final String TABLE_NAME = "t_authentication";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_authentication_seq")
    @Column(name = "id_authentication")
    private Integer id;

    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private User user;

    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    public AuthenticationToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }

    public AuthenticationToken(Integer id, String Token, Date createdDate, User user) {
        this.id = id;
        this.token = Token;
        this.createdDate = createdDate;
        this.user = user;
    }

    public AuthenticationToken() {
    }
}