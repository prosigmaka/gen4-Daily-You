package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Product;

public interface CartService {
    void saveToCart(Cart cart, AddToCartDto addToCartDto);
}

