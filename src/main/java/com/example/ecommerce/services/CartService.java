package com.example.ecommerce.services;

import com.example.ecommerce.domain.dto.CartDto;
import com.example.ecommerce.domain.dto.CartItemDto;

public interface CartService {

    CartDto getCartByUserId(Long userId);

    CartDto addItemToCart(Long userId, CartItemDto cartItemDto);

    CartDto updateCartItem(Long userId, Long cartItemId, Integer quantity);

    void removeCartItem(Long userId, Long cartItemId);

    void clearCart(Long userId);
}
