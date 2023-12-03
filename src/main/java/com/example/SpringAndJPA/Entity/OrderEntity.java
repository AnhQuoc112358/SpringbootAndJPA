package com.example.SpringAndJPA.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_code")
    private String orderCode;
    @Column(name = "total_amount")
    private float totalAmount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
