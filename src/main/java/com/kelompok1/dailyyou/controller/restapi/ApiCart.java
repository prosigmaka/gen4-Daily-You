package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.service.CartService;
import com.kelompok1.dailyyou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class ApiCart {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, User user){
        Product product = productService.getProductById(addToCartDto.getProductId());
        cartService.addToCart(addToCartDto, product, user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems() {
        CartDto cartDto = cartService.listCartItems();
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto, User user){
        Product product = productService.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto, user, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemId, User user) {
        cartService.deleteCartItem(itemId, user.getId());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}