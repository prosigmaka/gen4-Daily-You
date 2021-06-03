package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.controller.restapi.RequestOrder;
import com.kelompok1.dailyyou.model.entity.OrderDetails;

public interface OrderDetailsService {

    Iterable <OrderDetails> getAllOrders();
    OrderDetails insertOrder(RequestOrder requestOrder);

}
