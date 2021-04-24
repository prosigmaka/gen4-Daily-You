package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<User, Integer> {

}
