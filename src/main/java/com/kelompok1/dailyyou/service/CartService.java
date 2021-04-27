package com.kelompok1.dailyyou.service;


import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.dto.CartItemDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private  CartRepository cartRepository;

    private User user;

    public CartService(){}

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto, Product product, User user){
        Cart cart = new Cart(product, addToCartDto.getProductQuantity(), user);
        cartRepository.save(cart);
    }


    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUser(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getProductQuantity());
        }
        CartDto cartDto = new CartDto(cartItems,totalCost);
        return cartDto;
    }


    public static CartItemDto getDtoFromCart(Cart cart) {
        CartItemDto cartItemDto = new CartItemDto(cart);
        return cartItemDto;
    }


    public void updateCartItem(AddToCartDto cartDto,Product product){
        Cart cart = cartRepository.getOne(cartDto.getId());
        cart.setProductQuantity(cartDto.getProductQuantity());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }
    public void deleteCartItem(int id) {
        cartRepository.deleteById(id);

    }

    public void deleteCartItems(int userId) {
        cartRepository.deleteAll();
    }

    public void deleteUserCartItems(User user) {
        cartRepository.deleteByUser(user);
    }
}