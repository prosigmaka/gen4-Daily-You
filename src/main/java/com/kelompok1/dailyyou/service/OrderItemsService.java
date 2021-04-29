package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.OrderItem;
import com.kelompok1.dailyyou.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public void addOrderedProducts(OrderItem orderItem) {
        orderItemsRepository.save(orderItem);
    }


}
