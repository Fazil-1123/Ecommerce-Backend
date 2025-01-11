package com.example.ecommerce.domain.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.ecommerce.domain.dto.CommentDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductDto(

        Long id,

        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "Description is mandatory")
        String description,
        @Positive(message = "Price must be greater than zero")
        BigDecimal price,
        Integer quantity,
        List<CommentDto> comments

) {
}