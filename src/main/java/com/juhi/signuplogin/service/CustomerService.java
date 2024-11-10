package com.juhi.signuplogin.service;

import com.juhi.signuplogin.dto.CustomerRequest;
import com.juhi.signuplogin.dto.CustomerResponse;
import com.juhi.signuplogin.dto.LoginRequest;
import com.juhi.signuplogin.entity.Customer;
import com.juhi.signuplogin.exception.CustomerNotFoundException;
import com.juhi.signuplogin.helper.EncryptionService;
import com.juhi.signuplogin.mapper.CustomerMapper;
import com.juhi.signuplogin.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import com.juhi.signuplogin.helper.JWTHelper;
import org.springframework.stereotype.Service;


import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }

    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(request.email());
    }

    public boolean deleteCustomer(String token) {

        token = jwtHelper.removeBearerFromToken(token);

        if (!jwtHelper.validateToken(token)) {
            throw new IllegalArgumentException("Invalid token");
        }

        String username = jwtHelper.extractUsername(token);

        Customer customer = customerRepo.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        customerRepo.delete(customer);
        return true;
    }


}
