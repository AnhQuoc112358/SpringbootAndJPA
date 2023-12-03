package com.example.SpringAndJPA.service;

import com.example.SpringAndJPA.Entity.OrderEntity;
import com.example.SpringAndJPA.repository.CustomerRepository;
import com.example.SpringAndJPA.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public OrderEntity addOrder(int customerId, OrderEntity order) {
        return customerRepository.findById(customerId).map(customer -> {
            order.setCustomer(customer);
            return orderRepository.saveAndFlush(order);
        }).orElse(null);
    }


    public List<OrderEntity> findListOrderByCustomerId(int id) {
        return orderRepository.findOrderEntitiesByCustomer_Id(id);
    }
}
