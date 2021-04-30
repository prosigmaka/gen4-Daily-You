package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer idUser;
    private String UserName;
    private String emailUser;
    private String password;
    private String fullName;
    private Number telepon;
    private String email;
}
