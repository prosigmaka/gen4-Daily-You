package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping()
    public List<CartDto> getListCart() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDto> cartDtos =
                cartList.stream()
                        .map(cart -> mapCartToCartDto(cart))
                        .collect(Collectors.toList());
        return cartDtos;
    }

    private CartDto mapCartToCartDto(Cart cart) {
        CartDto cartDto = modelMapper.map(cart, CartDto.class);
        modelMapper.map(cart.getProduct(), cartDto);
        cartDto.setIdProduct(cart.getProduct().getId());
        cartDto.setId(cart.getId());
        return cartDto;
    }

    @GetMapping("/{id}")
    public CartDto getCart(@PathVariable Integer id) {
        Cart cart = cartRepository.findById(id).get();
        CartDto cartDto = new CartDto();
        modelMapper.map(cart, cartDto);
        modelMapper.map(cart.getProduct(), cartDto);

        return cartDto;
    }

    @PostMapping
    public CartDto editsaveCart(@RequestBody CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        cart.setIdProduct(cartDto.getIdProduct());
        cart.setId(cartDto.getId());
        cart= cartService.save(cart);
        CartDto cartDtoDB =mapCartToCartDto(cart);
        return cartDtoDB;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartRepository.deleteById(id);
    }

}
