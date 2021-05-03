package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    //Data yang direpresentasikan untuk komunikasi antara FE dan BE
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}