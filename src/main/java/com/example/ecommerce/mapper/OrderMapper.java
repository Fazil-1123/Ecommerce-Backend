package com.example.ecommerce.mapper;

import com.example.ecommerce.domain.dto.OrderDto;
import com.example.ecommerce.domain.dto.OrderItemDto;
import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.domain.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "user.id", source = "userId")
    Order fromDto(OrderDto orderDto);

    @Mapping(target = "userId", source = "user.id")
    OrderDto toDto(Order order);

    List<OrderDto> toDto(List<Order> orders);

    List<Order> fromDto(List<OrderDto> orderDtos);

    @Mapping(target = "productId", source = "product.id")
    OrderItemDto toDto(OrderItem orderItem);

    @Mapping(target = "product.id", source = "productId")
    OrderItem fromDto(OrderItemDto orderItemDto);

    List<OrderItemDto> toOrderItemsDto(List<OrderItem> orderItems);

    List<OrderItem> fromOrderItemsDto(List<OrderItemDto> orderItemDtos);
}
