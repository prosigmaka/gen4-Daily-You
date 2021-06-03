package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String username;
    private String emailUser;
    private String address;
    private String phone;
    private String password;
    private Long idRole;
}