package com.example.ecommerce.domain.dto;

import java.util.List;

public record CartDto(
        Long id,
        Long userId,
        List<CartItemDto> cartItems
) {
}
