package com.kelompok1.dailyyou.model.entity;

import lombok.Data;
import javax.persistence.*;

//Annotation Entity menunjukkan bahwa berfungsi untuk Representasi data di database
@Entity
//Annotation Lombok untuk setter getter manual
@Data
//Annotation untuk pemberian nama tabel
@Table(name =  "users")
public class Users {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    // Nullable fungsinya untuk memastikan bahwa nilai pada kolom tersebut tidak boleh kosong.
    // Karena nilai nya false, maka nilai pada kolom tersebut boleh kosong
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    //Tabel user memiliki relasi many to one dengan tabel role
    //Many To One --> Banyak user mempunyai satu role yang sama
    @ManyToOne
    @JoinColumn(name = "roles", insertable = false, updatable = false)
    private Role roles;

    //
    @Column(name="roles")
    private Long roleId;



}