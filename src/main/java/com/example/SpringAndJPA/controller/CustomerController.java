
package com.example.SpringAndJPA.controller;

import com.example.SpringAndJPA.Entity.CustomerEntity;
import com.example.SpringAndJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
//  1. Thêm mới khách hàng
    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerEntity customer) {
        customerService.addCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//    2. Lấy danh sách tất cả khách hàng
    @GetMapping("")
    public ResponseEntity<?> findAllCustomer() {
        List<CustomerEntity> listCustomer = customerService.findAllCustomer();
        return new ResponseEntity<>(listCustomer, HttpStatus.OK);
    }
//    3. Lấy thông tin khách hàng theo Id
    @GetMapping("/find")
    public ResponseEntity<?> findCustomerById(@RequestParam int id) {
        CustomerEntity customer = customerService.findCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}

