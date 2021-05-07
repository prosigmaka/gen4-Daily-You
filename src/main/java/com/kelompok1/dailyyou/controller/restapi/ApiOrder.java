package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class ApiOrder {

    @Autowired
    public OrderService orderService;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(path = "/insert")
    public @ResponseBody
    Order insertOrder(@RequestBody RequestOrder requestOrder) {
        return orderService.insertOrder(requestOrder);

    }

}
