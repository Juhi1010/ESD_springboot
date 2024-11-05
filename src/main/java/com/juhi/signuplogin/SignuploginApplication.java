package com.juhi.signuplogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SignuploginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignuploginApplication.class, args);
    }

}
