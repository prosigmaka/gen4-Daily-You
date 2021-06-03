package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT product FROM Product product order by product.id", nativeQuery = false)
    List<Product> findAllOrderById();

//    @Query(value = "SELECT * FROM product WHERE judul_buku ~* ?1", nativeQuery = true)
//    List<Product> searchBook(String keyword);
//
//    List<Product> findAllByIdKategori(Integer id);

    @Query(value = "select product.price from Product product where product.id = ?1", nativeQuery = false)
    Double getPriceById(Integer id);

}
