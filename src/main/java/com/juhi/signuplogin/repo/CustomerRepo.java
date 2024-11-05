package com.juhi.signuplogin.repo;

import com.juhi.signuplogin.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
