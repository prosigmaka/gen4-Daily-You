package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.dto.RequestCartItemIdList;
import com.kelompok1.dailyyou.model.entity.OrderItems;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.service.CartService;
import com.kelompok1.dailyyou.service.CheckoutService;
import com.kelompok1.dailyyou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class ApiCheckout {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/checkout")
    public OrderItems orderItems(@RequestBody RequestCartItemIdList requestCartItemIdList){

      return null;
    };




}