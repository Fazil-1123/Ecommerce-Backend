package com.example.ecommerce.domain.dto;

public record CommentDto(
        Long id,
        String content,
        Integer rating,
        Long userId
) {
}
