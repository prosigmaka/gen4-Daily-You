package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.configuration.exception.OrderNotFoundException;
import com.kelompok1.dailyyou.configuration.exception.ProductNotExistException;
import com.kelompok1.dailyyou.model.dto.CheckoutDto;
import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class ApiOrder {
    @Autowired
    private OrderService orderService;

//    @Autowired
//    private AuthenticationService authenticationService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder()
            throws ProductNotExistException {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
        orderService.placeOrder();
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(){
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
        List<Order> orderDtoList = orderService.listOrders();
        return new ResponseEntity<List<Order>>(orderDtoList, HttpStatus.OK);
    }

}
