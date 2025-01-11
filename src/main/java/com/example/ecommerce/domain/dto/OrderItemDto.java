package com.example.ecommerce.domain.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderItemDto(
        Long id,
        Long productId,
        @Positive(message = "Quantity must be greater than zero")
        Integer quantity,
        @Positive(message = "Price must be greater than zero")
        BigDecimal price
) {
}
