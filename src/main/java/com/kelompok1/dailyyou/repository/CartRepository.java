package com.kelompok1.dailyyou.repository;

import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT cart FROM Cart cart WHERE cart.id = ?1 AND cart.status = 'BELUM_BAYAR'", nativeQuery = false)
    List<Cart> findAllByIdCart(Integer id);

    List<Cart> findAllByIdUser(Long id);

    Cart findByIdProductAndIdUser(Integer idProduct, Long idUser);

    List<Cart> findAllByIdUserAndStatus(Long id, String status);
}
