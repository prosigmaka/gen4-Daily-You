package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
