package com.kelompok1.dailyyou.service;


import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.dto.CartItemIdDto;
import com.kelompok1.dailyyou.model.dto.RequestCartItemIdList;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.OrderItems;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CheckoutServiceImp implements CheckoutService{

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public OrderItems checkoutOrderItem(RequestCartItemIdList requestCartItemIdList) {
        Order order = new Order();
        Date tanggalCheckout = new Date();
        order.setBatasPembayaran(tanggalCheckout);
        Order orderN = checkoutRepository.save(order);

        List<OrderItems> orderItemsList = new ArrayList<OrderItems>();

        double totalCost = 0;

        for (CartItemIdDto cartItemIdDto : requestCartItemIdList.getRequestCartItemIdList()) {
            Cart cart = new Cart();

            OrderItems orderItems = new OrderItems();
            orderItems.setIdOrder(orderItems.getOrder().getId());
            orderItems.setIdCart(orderItems.getCart().getId());
            totalCost+= cart.getProduct().getPrice()*cart.getProductQuantity();
            return null;
        }
        return null;
    }
}