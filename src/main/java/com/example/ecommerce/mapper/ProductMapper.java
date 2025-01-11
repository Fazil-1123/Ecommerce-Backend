package com.example.ecommerce.mapper;

import com.example.ecommerce.domain.dto.CommentDto;
import com.example.ecommerce.domain.dto.ProductDto;
import com.example.ecommerce.domain.entities.Comment;
import com.example.ecommerce.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product fromDto(ProductDto productDto);

    ProductDto toDto(Product product);


}
