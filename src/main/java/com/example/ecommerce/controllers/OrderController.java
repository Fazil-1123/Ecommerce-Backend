package com.example.ecommerce.controllers;

import com.example.ecommerce.domain.dto.OrderDto;
import com.example.ecommerce.domain.entities.OrderStatus;
import com.example.ecommerce.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}")
    public OrderDto placeOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {
        return orderService.placeOrder(userId, orderDto);
    }

    @GetMapping("/{userId}")
    public List<OrderDto> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PutMapping("/{orderId}/status")
    public OrderDto updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}
