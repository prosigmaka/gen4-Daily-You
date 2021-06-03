package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// interface sehingga hanya berisi abstract method
/*
    JpaRepository<1?, 2?>
    1? = berisi model entity
    2? = berisi tipe data primary key dari model entity*/
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> findAll();


    Optional<OrderDetails> findById(Integer id);
}
