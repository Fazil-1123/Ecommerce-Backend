package com.example.ecommerce.services.impl;

import com.example.ecommerce.domain.dto.CartDto;
import com.example.ecommerce.domain.dto.CartItemDto;
import com.example.ecommerce.domain.entities.Cart;
import com.example.ecommerce.domain.entities.CartItem;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.mapper.CartMapper;
import com.example.ecommerce.repositories.CartRepository;
import com.example.ecommerce.repositories.ProductsRepository;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.services.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductsRepository productsRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductsRepository productsRepository, CartMapper cartMapper, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productsRepository = productsRepository;
        this.cartMapper = cartMapper;
        this.userRepository = userRepository;
    }

    @Override
    public CartDto getCartByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found for user ID: " + userId));
        return cartMapper.toDto(cart);
    }

    @Override
    public CartDto addItemToCart(Long userId, CartItemDto cartItemDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found for ID: " + userId));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user); // Associate the user with the new cart
                    newCart.setCartItems(new ArrayList<>());
                    return newCart;
                });


        Product product = productsRepository.findById(cartItemDto.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found for ID: " + cartItemDto.productId()));

        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> Objects.equals(item.getProduct().getId(), cartItemDto.productId()))
                .findFirst()
                .orElseGet(() -> {
                    CartItem newCartItem = new CartItem();
                    newCartItem.setCart(cart);
                    newCartItem.setProduct(product);
                    cart.getCartItems().add(newCartItem);
                    return newCartItem;
                });

        cartItem.setQuantity(cartItemDto.quantity());
        cartRepository.save(cart);

        return cartMapper.toDto(cart);
    }

    @Override
    public CartDto updateCartItem(Long userId, Long cartItemId, Integer quantity) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found for user ID: " + userId));

        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> Objects.equals(item.getId(), cartItemId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cart item not found"));

        cartItem.setQuantity(quantity);
        cartRepository.save(cart);

        return cartMapper.toDto(cart);
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found for user ID: " + userId));

        cart.getCartItems().removeIf(item -> Objects.equals(item.getId(), cartItemId));
        cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found for user ID: " + userId));

        cart.getCartItems().clear();
        cartRepository.save(cart);
    }
}
