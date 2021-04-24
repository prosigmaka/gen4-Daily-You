package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
