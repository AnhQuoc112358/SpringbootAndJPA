package com.example.SpringAndJPA.repository;

import com.example.SpringAndJPA.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findOrderEntitiesByCustomer_Id(int customerId);
}
