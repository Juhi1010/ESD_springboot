package com.juhi.signuplogin.service;

import com.juhi.signuplogin.dto.CustomerRequest;
import com.juhi.signuplogin.dto.LoginRequest;
import com.juhi.signuplogin.entity.Customer;
import com.juhi.signuplogin.mapper.CustomerMapper;
import com.juhi.signuplogin.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created";
    }

    public boolean login(String email, String password) {
        Optional<Customer> customer = repo.findByEmailAndPassword(email, password);
        return customer.isPresent();
    }

}
