package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(Users user);

}

