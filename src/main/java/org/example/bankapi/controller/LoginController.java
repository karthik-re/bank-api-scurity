package org.example.bankapi.controller;

import org.example.bankapi.DTO.RegisterDTO;
import org.example.bankapi.entity.Customer;
import org.example.bankapi.repository.CustomerRepository;
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

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if(customerRepository.existsByEmail(registerDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already taken");
        }
        Customer customer = new Customer();
        customer.setEmail(registerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        customer.setRole(registerDTO.getRole());

        customerRepository.save(customer);

        return ResponseEntity.ok("User registered successfully");
    }

}
