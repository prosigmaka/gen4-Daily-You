package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
