package com.example.SpringAndJPA.controller;

import com.example.SpringAndJPA.Entity.OrderEntity;
import com.example.SpringAndJPA.service.CustomerService;
import com.example.SpringAndJPA.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
//  4. Tạo đơn hàng mới và liên kết với khách hàng dựa trên Id khách hàng
    @PostMapping("/add/{customerId}")
    public ResponseEntity<OrderEntity> CreateOrderForCustomer(@PathVariable int customerId, @RequestBody OrderEntity order) {
        OrderEntity orderAdd = orderService.addOrder(customerId, order);
        return new ResponseEntity<>(orderAdd, HttpStatus.OK);
    }

//    5. Lấy danh sách đơn hàng theo Id khách hàng
    @GetMapping("/find")
    public ResponseEntity <List<OrderEntity>> findListOrderByCustomerId(@RequestParam int customerId) {
        List<OrderEntity> listOrderByCustomerId = orderService.findListOrderByCustomerId(customerId);
        return new ResponseEntity <List<OrderEntity>>(listOrderByCustomerId, HttpStatus.OK);
    }
}
