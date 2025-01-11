package com.example.ecommerce.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
