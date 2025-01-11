package com.example.ecommerce.mapper;

import com.example.ecommerce.domain.dto.CartDto;
import com.example.ecommerce.domain.dto.CartItemDto;
import com.example.ecommerce.domain.entities.Cart;
import com.example.ecommerce.domain.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "userId", source = "user.id")
    CartDto toDto(Cart cart);

    @Mapping(target = "user.id", source = "userId")
    Cart fromDto(CartDto cartDto);

    @Mapping(target = "productId", source = "product.id")
    CartItemDto toDto(CartItem cartItem);

    @Mapping(target = "product.id", source = "productId")
    CartItem fromDto(CartItemDto cartItemDto);
}
