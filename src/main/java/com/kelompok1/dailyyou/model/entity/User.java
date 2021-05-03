package com.kelompok1.dailyyou.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "role")
//    private Role role;

//    @Column(name = "password")
//    private String password;

//    @JsonIgnore
//    @OneToMany(mappedBy = "user",
//            fetch = FetchType.LAZY)
//
//    private List<Order> orders;
    public User() {

    }

    public User(String firstName, String lastName, String email, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
////        this.role = role;
//        this.password = password;
    }
};

