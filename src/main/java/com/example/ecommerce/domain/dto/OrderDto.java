package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.domain.entities.OrderStatus;

import java.util.List;

public record OrderDto(

        Long id,
        Long userId,
        String address,
        String phoneNumber,
        OrderStatus status,
        List<OrderItemDto> orderItem
) {
}
