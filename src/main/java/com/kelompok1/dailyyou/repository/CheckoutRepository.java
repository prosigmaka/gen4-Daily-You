package com.kelompok1.dailyyou.repository;


import com.kelompok1.dailyyou.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CheckoutRepository extends JpaRepository<Order, Integer> {

    List<Order> findAll();
}
