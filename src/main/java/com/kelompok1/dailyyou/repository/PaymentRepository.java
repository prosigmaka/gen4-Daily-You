package com.kelompok1.dailyyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kelompok1.dailyyou.model.entity.Users;

@Repository
public interface PaymentRepository extends JpaRepository<Users, Integer> {

}
