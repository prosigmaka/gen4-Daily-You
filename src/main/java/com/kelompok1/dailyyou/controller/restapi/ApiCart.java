package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.service.CartService;
import com.kelompok1.dailyyou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ApiCart {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto){
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add"+  product.getProductName());
        cartService.addToCart(addToCartDto, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems() {
        CartDto cartDto = cartService.listCartItems();
        return new ResponseEntity<CartDto>(HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto){
        Product product = productService.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto,product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemId) {
        cartService.deleteCartItem(itemId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public void deleteCartItems() {
        cartRepository.deleteAll();
    }

}