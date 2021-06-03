package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.dto.CartItemsDto;
import com.kelompok1.dailyyou.model.dto.LoginDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.OrderStatus;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.UserRepository;
import com.kelompok1.dailyyou.service.CartService;
import com.kelompok1.dailyyou.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cart")
public class ApiCart {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private Long currentIdUser(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Long idUser = userRepository.findIdByUserName(userName);
        return idUser;
    }

    @GetMapping("/idUser")
    public Long getIdUser(LoginDto loginDto){
        return loginDto.getIdUserLogin();
    }

    @GetMapping
    public List<CartDto> getAll() {
        List<Cart> cartList = cartRepository.findAllByIdUserAndStatus(currentIdUser(), String.valueOf(OrderStatus.BELUM_BAYAR));
        List<CartDto> cartDtooList = cartList
                .stream()
                .map(cart -> mapToCartDto(cart))
                .collect(Collectors.toList());
        return cartDtooList;
    }

    @PostMapping()
    public List<AddToCartDto> saveCart(@RequestBody CartItemsDto cartItemsDto){
        List<AddToCartDto> addToCartDtoList = cartItemsDto.getAddToCart()
                .stream()
                .map(cart -> mapToCartDto(cart)).collect(Collectors.toList());
        return addToCartDtoList;
    }


    private AddToCartDto mapToCartDto(AddToCartDto addToCartDto){
        AddToCartDto addToCartDto1 = modelMapper.map(addToCartDto, AddToCartDto.class);
        Cart cart = modelMapper.map(addToCartDto1, Cart.class);
        cart.setIdUser(currentIdUser());
        cartService.saveToCart(cart, addToCartDto);
        return cart;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        cartRepository.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        cartRepository.deleteAll();
    }


    private CartDto mapToCartDto(Cart cart){
        CartDto cartDto = modelMapper.map(cart, CartDto.class);
        cartDto.setProductName(cart.getProduct().getProductName());
        cartDto.setPrice(cart.getProduct().getPrice());
        cartDto.setSubTotalPrice(cart.getSubTotalPrice());
        return cartDto;
    }

}
