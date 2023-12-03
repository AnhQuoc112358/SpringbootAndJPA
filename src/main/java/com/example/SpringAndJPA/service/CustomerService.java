
package com.example.SpringAndJPA.service;

import com.example.SpringAndJPA.Entity.CustomerEntity;
import com.example.SpringAndJPA.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public void addCustomer(CustomerEntity customer) {
        customerRepository.saveAndFlush(customer);
    }
    public List<CustomerEntity> findAllCustomer() {
        return customerRepository.findAll();
    }
    public CustomerEntity findCustomerById(int id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
    }
}
