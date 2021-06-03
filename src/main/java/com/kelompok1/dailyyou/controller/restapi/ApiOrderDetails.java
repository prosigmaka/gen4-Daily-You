package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.entity.OrderDetails;
import com.kelompok1.dailyyou.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class ApiOrderDetails {
    @Autowired
    public OrderDetailsService orderDetailsService;

//    @Autowired
//    private CheckoutOrderService checkoutOrderService;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<OrderDetails> getAllOrders() {
        return orderDetailsService.getAllOrders();
    }

    @PostMapping(path = "/insert")
    public @ResponseBody
    OrderDetails insertOrder(@RequestBody RequestOrder requestOrder) {
        return orderDetailsService.insertOrder(requestOrder);

    }
}