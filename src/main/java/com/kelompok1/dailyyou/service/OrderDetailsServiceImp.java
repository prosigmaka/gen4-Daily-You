package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.controller.restapi.RequestOrder;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.OrderDetails;
import com.kelompok1.dailyyou.model.entity.OrderItems;
import com.kelompok1.dailyyou.model.entity.OrderStatus;
import com.kelompok1.dailyyou.repository.CartRepository;
import com.kelompok1.dailyyou.repository.OrderDetailsRepository;
import com.kelompok1.dailyyou.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderDetailsServiceImp implements OrderDetailsService{

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    CartRepository cartRepository;



    @Override
    public Iterable<OrderDetails> getAllOrders() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails insertOrder(RequestOrder requestOrder) {
        Object keys[] = requestOrder.getCart().keySet().toArray();
        int keranjang_index[] = new int[keys.length];
        for (int i = 0; i < keranjang_index.length; i++){
            keranjang_index[i] = (Integer) requestOrder.getCart().keySet().toArray()[i];
        }
        OrderDetails orderDetails = new OrderDetails();
        double total = 0.0;
        for (int i = 0; i < keranjang_index.length; i++){
            Optional<Cart> keranjang = cartRepository.findById(keranjang_index[i]);
            Cart k = keranjang.get();
            OrderItems orderItems = new OrderItems();
            orderItems.setCart(k);
            total += k.getSubTotalPrice();
            orderDetails.getItems().add(orderItems);
            orderItemsRepository.save(orderItems);
        }
        orderDetails.setTanggalCi(new Date());
        orderDetails.setTotalHargalCi(total);
        orderDetails.setTipePembayaran("Via Transfer");
        orderDetails.setBatasTanggalPembayaran(new Date());
        orderDetails.setOrderStatus(OrderStatus.BELUM_BAYAR);
        return orderDetailsRepository.save(orderDetails);
    }
}
