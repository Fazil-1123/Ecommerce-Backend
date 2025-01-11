package com.example.ecommerce.domain.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.ecommerce.domain.dto.CommentDto;

public record ProductDto(

        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer quantity,
        List<CommentDto> comments

) {
}