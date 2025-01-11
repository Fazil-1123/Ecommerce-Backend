package com.example.ecommerce.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CommentDto(
        Long id,
        @NotBlank(message = "Content is mandatory")
        String content,
        @Min(value = 1)
        @Max(value = 5)
        Integer rating,
        Long userId
) {
}
