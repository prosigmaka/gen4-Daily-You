package com.kelompok1.dailyyou.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class CartController {
    //    dashboard
    @GetMapping("cart")
    public String cartItem() {
        return "checkout/checkout";
    }

    @GetMapping("order")
    public String order() {
        return "checkout/order";
    }
};
