package com.example.ecommerce.domain.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long id,
        Long productId,
        Integer quantity,
        BigDecimal price
) {
}
