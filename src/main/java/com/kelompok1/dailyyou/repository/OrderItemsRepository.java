package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

    List<OrderItems> findAll();


    Optional<OrderItems> findById(Integer id);
}

