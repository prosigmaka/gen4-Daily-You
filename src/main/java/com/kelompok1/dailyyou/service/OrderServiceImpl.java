package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.controller.restapi.RequestOrder;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.OrderItems;
import com.kelompok1.dailyyou.model.entity.PaymentStatus;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.OrderItemsRepository;
import com.kelompok1.dailyyou.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order insertOrder(RequestOrder requestOrder) {
        Object keys[] = requestOrder.getCart().keySet().toArray();
        int keranjang_index[] = new int[keys.length];
        for (int i = 0; i < keranjang_index.length; i++){
            keranjang_index[i] = (Integer) requestOrder.getCart().keySet().toArray()[i];
        }
        Order order = new Order();
        double total = 0.0;
        for (int i = 0; i < keranjang_index.length; i++){
            Optional<Cart> cart = cartRepository.findById(keranjang_index[i]);
            Cart k = cart.get();

            OrderItems orderItem = new OrderItems();
            orderItem.setCart(k);

            total += k.getProductQuantity();
            order.getItems().add(orderItem);
            orderItemsRepository.save(orderItem);
        }

        order.setTotalCost(total);
        order.setBatasTanggalPembayaran(new Date());
        order.setPaymentStatus(PaymentStatus.BELUM_BAYAR);
        return orderRepository.save(order);
    }
}
