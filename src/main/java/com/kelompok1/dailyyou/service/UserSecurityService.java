package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserSecurityService extends UserDetailsService {
    User save(User user);
}
