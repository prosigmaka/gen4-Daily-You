package com.kelompok1.dailyyou.model.entity;

import com.kelompok1.dailyyou.model.common.CommonModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_user")
public class User extends CommonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usrid")
    private Long id;
    @Column(name = "usremail", unique = true, nullable = false)
    private String email;
    @Column(name = "usrnm", nullable = false, unique = true)
    private String username;
    @Column(name = "usrhp", unique = true, nullable = false)
    private String noHp;
    @Column(name = "userkeyid", unique = true)
    private String userKeyId;
    @Column(name = "usrktp", unique = true)
    private String ktp;
    @Column(name = "usralamat")
    private String alamat;
}
