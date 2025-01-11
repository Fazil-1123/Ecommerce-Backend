package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.domain.entities.OrderStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(

        Long id,
        Long userId,
        @NotBlank(message = "Address is mandatory")
        String address,
        @NotBlank(message = "Phone number is mandatory")
        String phoneNumber,
        OrderStatus status,
        LocalDateTime createdAt,
        List<OrderItemDto> orderItems
) {
}
