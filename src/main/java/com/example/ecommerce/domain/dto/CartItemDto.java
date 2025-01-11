package com.example.ecommerce.domain.dto;

public record CartItemDto(
        Long id,
        Long productId,
        Integer quantity
) {
}
