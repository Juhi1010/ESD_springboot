package com.juhi.signuplogin.mapper;

import com.juhi.signuplogin.dto.CustomerRequest;
import com.juhi.signuplogin.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
}
