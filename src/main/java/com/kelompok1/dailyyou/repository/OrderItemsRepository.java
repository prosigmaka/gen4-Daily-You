package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository <OrderItem,Integer> {

}

