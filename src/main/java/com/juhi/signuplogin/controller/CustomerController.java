package com.juhi.signuplogin.controller;

import com.juhi.signuplogin.dto.CustomerRequest;
import com.juhi.signuplogin.dto.CustomerResponse;
import com.juhi.signuplogin.dto.LoginRequest;
import com.juhi.signuplogin.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("email") String email) {
        return ResponseEntity.ok(customerService.retrieveCustomer(email));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(customerService.login(request));
    }

//    @PostMapping("/update")
//    public ResponseEntity<?> updateCustomer(@RequestHeader("Authorization") String token, @RequestBody CustomerRequest updatedCustomer) {
//        return ResponseEntity.ok(customerService.updateCustomer(token, updatedCustomer));
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestHeader("Authorization") String token) {

            boolean deleted = customerService.deleteCustomer(token);

            if (deleted) {
                return ResponseEntity.ok("Customer deleted successfully");
            }
        return ResponseEntity.status(401).body("Error deleting customer");

    }


}
