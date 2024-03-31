package org.example.bankapi.controller;

import org.example.bankapi.DTO.RegisterDTO;
import org.example.bankapi.entity.Customer;
import org.example.bankapi.repository.CustomerRepository;
import org.example.bankapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final CustomerService customerService;

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if(customerService.existsByEmail(registerDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already taken");
        }
        customerService.createCustomer(registerDTO);
        return ResponseEntity.ok("User registered successfully");
    }

}
