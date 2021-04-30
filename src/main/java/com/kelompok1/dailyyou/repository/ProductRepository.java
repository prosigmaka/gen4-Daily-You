package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM t_product where id_category =?1", nativeQuery = true)
    List<Product> cariProductCategory(Integer id);
}
