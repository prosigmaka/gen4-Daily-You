package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.dto.UserDto;
import com.kelompok1.dailyyou.model.dto.RegisterDto;

public interface UserService {
    UserDto findByUsername(String username);
    public RegisterDto saveRegister(RegisterDto registerDto);
}
