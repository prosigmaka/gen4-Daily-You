package com.kelompok1.dailyyou.model.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class LoginDto {
    private Long idUserLogin;
    private String usernameLogin;
}