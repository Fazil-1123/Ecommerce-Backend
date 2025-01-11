package com.example.ecommerce.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user who places this order
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String address;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // e.g. NEW, SHIPPED, DELIVERED, etc.

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
}
