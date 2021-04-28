package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
