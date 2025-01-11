package com.example.ecommerce.services;

import com.example.ecommerce.domain.dto.OrderDto;
import com.example.ecommerce.domain.entities.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderDto placeOrder(Long userId, OrderDto orderDto);

    List<OrderDto> getOrdersByUserId(Long userId);

    OrderDto updateOrderStatus(Long orderId, OrderStatus status);
}
