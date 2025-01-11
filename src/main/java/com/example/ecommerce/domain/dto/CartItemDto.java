package com.example.ecommerce.domain.dto;

import jakarta.validation.constraints.Positive;

public record CartItemDto(
        Long id,
        Long productId,
        @Positive(message = "Quantity must be greater than zero")
        Integer quantity
) {
}
