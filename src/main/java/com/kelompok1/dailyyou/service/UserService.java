package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
