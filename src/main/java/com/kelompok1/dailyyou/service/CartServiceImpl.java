package com.kelompok1.dailyyou.service;


import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveToCart(Cart cart, AddToCartDto addToCartDto) {
        List<Cart> cartList = cartRepository.findAllByIdUser(cart.getIdUser());

        Double price = productRepository.getPriceById(addToCartDto.getId());

        if (cart != null) {                 // kondisi jika id user ada di database
            Cart cart1 = cartRepository.findByIdProductAndIdUser(addToCartDto.getIdProduct(), cart.getIdUser());
            if (cart1 != null) {            // kondisi untuk modal cart maka update data
                cart1.setProductQuantity(addToCartDto.getProductQuantity());
                Double quantity1 = Double.valueOf(cart1.getProductQuantity());
                cart1.setSubTotalPrice(price * quantity1);
                cartRepository.save(cart1);
            } else {                        // kondisi jika id buku tidak ada dalam database maka buat data baru
                cart.setProductQuantity(1);
                cart.setSubTotalPrice(price);
//                cart.setStatusCart(ItemStatus.ADD_TO_CART.toString());
                cartRepository.save(cart);
            }
        } else {                            // kondisi jika id user dan id buku tidak ada dalam database
            cart.setProductQuantity(1);
            cart.setSubTotalPrice(price);
            cart.setIdUser(cart.getIdUser());
//            cart.setStatusCart(ItemStatus.ADD_TO_CART.toString());
            cartRepository.save(cart);
        }
    }
}
