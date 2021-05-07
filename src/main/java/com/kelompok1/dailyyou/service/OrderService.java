package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.controller.restapi.RequestOrder;
import com.kelompok1.dailyyou.model.entity.Order;

public interface OrderService {
    Iterable <Order> getAllOrders();
    Order insertOrder(RequestOrder requestOrder);
}
