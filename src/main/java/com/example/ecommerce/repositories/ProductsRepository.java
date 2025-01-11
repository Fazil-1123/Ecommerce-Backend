package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
