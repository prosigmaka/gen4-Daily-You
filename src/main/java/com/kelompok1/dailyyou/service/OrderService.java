package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.configuration.exception.OrderNotFoundException;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.dto.CartItemDto;
import com.kelompok1.dailyyou.model.dto.PlaceOrderDto;
import com.kelompok1.dailyyou.model.entity.Order;
import com.kelompok1.dailyyou.model.entity.OrderItem;
import com.kelompok1.dailyyou.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    OrderItemsService orderItemsService;
//
//    @Value("${BASE_URL}")
//    private String baseURL;
//
//    @Value("${STRIPE_SECRET_KEY}")
//    private String apiKey;

    public Order saveOrder(PlaceOrderDto orderDto) {
        Order order = getOrderFromDto(orderDto);
        return orderRepository.save(order);
    }

    private Order getOrderFromDto(PlaceOrderDto orderDto) {
        Order order = new Order(orderDto);
        return order;
    }

    public List<Order> listOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

//    public Order getOrder(int orderId) throws OrderNotFoundException {
//        Optional<Order> order = orderRepository.findById(orderId);
//        if (order.isPresent()) {
//            return order.get();
//        }
//        throw new OrderNotFoundException("Order not found");
//    }


    public void placeOrder() {
        CartDto cartDto = cartService.listCartItems();

        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
//        placeOrderDto.setUser(user);
        placeOrderDto.setTotalPrice(cartDto.getTotalCost());

        Order newOrder = saveOrder(placeOrderDto);
        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();
        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem(
                    newOrder,
                    cartItemDto.getProduct(),
                    cartItemDto.getProductQuantity(),
                    cartItemDto.getProduct().getPrice());
            orderItemsService.addOrderedProducts(orderItem);
        }
//        cartService.deleteUserCartItems();
    }
}