package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.Users;
import com.kelompok1.dailyyou.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users save(UserRegistrationDto registrationDto);

    boolean checkIfUserExist(String email);
}
