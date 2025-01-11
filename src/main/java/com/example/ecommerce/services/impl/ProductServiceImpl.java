package com.example.ecommerce.services.impl;

import com.example.ecommerce.domain.dto.ProductDto;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.repositories.ProductsRepository;
import com.example.ecommerce.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductsRepository productsRepository, ProductMapper productMapper) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productsRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        if(productDto.id() != null) {
            throw new IllegalArgumentException("Product already has an ID!");
        }
        Product savedProduct = productsRepository.save(productMapper.fromDto(productDto));
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        if(productDto.id() == null) {
            throw new IllegalArgumentException("Product must have an ID!");
        }
        if(!Objects.equals(productDto.id(), id)) {
            throw new IllegalArgumentException("Product ID cant be changed");
        }

        Product existingProduct = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found!"));

        existingProduct.setName(productDto.name());
        existingProduct.setDescription(productDto.description());
        existingProduct.setPrice(productDto.price());
        existingProduct.setQuantity(productDto.quantity());

        Product updatedProduct = productsRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);

    }

    @Override
    public ProductDto getProductById(Long id) {
        return productsRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Product not found!"));
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
