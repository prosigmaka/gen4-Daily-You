package com.kelompok1.dailyyou.service;


import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Cart save(Cart cart) {
        cart = cartRepository.save(cart);
        cart.setProduct(productRepository.findById(cart.getIdProduct()).get());
        return cart;
    }


}
//    public CartServiceImpl(){}
//
//    public CartServiceImpl(CartRepository cartRepository) {
//        this.cartRepository = cartRepository;
//    }
//
//    public void addToCart(AddToCartDto addToCartDto, Product product, User user){
//        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
//        cartRepository.save(cart);
//    }
//
//
//    public CartDto listCartItems(User user) {
//        List<Cart> cartList = cartRepository.findAllByUser(user);
//        List<CartItemDto> cartItems = new ArrayList<>();
//        for (Cart cart:cartList){
//            CartItemDto cartItemDto = getDtoFromCart(cart);
//            cartItems.add(cartItemDto);
//        }
//        double totalCost = 0;
//        for (CartItemDto cartItemDto :cartItems){
//            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
//        }
//        CartDto cartDto = new CartDto(cartItems,totalCost);
//        return cartDto;
//    }
//
//
//    public static CartItemDto getDtoFromCart(Cart cart) {
//        CartItemDto cartItemDto = new CartItemDto(cart);
//        return cartItemDto;
//    }
//
//
//    public void updateCartItem(AddToCartDto cartDto, User user,Product product){
//        Cart cart = cartRepository.getOne(cartDto.getId());
//        cart.setProductQuantity(cartDto.getProductQuantity());
//        cartRepository.save(cart);
//    }
//
//    public void deleteCartItem(int id,int userId) throws CartItemNotExistException {
//        if (!cartRepository.existsById(id))
//            throw new CartItemNotExistException("Cart id is invalid : " + id);
//        cartRepository.deleteById(id);
//
//    }
//
//    public void deleteCartItems(int userId) {
//        cartRepository.deleteAll();
//    }
//
//
//    public void deleteUserCartItems(User user) {
//        cartRepository.deleteByUser(user);
//    }
//}
