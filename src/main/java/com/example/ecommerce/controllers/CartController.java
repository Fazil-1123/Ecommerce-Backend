package com.example.ecommerce.controllers;

import com.example.ecommerce.domain.dto.CartDto;
import com.example.ecommerce.domain.dto.CartItemDto;
import com.example.ecommerce.services.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public CartDto getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/items")
    public CartDto addItemToCart(@PathVariable Long userId, @RequestBody CartItemDto cartItemDto) {
        return cartService.addItemToCart(userId, cartItemDto);
    }

    @PutMapping("/{userId}/items/{cartItemId}")
    public CartDto updateCartItem(@PathVariable Long userId, @PathVariable Long cartItemId, @RequestParam Integer quantity) {
        return cartService.updateCartItem(userId, cartItemId, quantity);
    }

    @DeleteMapping("/{userId}/items/{cartItemId}")
    public void removeCartItem(@PathVariable Long userId, @PathVariable Long cartItemId) {
        cartService.removeCartItem(userId, cartItemId);
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}
