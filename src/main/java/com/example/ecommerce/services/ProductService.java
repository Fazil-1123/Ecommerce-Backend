package com.example.ecommerce.services;

import com.example.ecommerce.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    ProductDto getProductById(Long id);

    void deleteProduct(Long id);
}
