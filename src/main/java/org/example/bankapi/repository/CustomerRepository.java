package org.example.bankapi.repository;

import org.example.bankapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Optional<Customer> findByEmail(String email); // This method is used to find a customer by email

    boolean existsByEmail(String email); // This method is used to check if a customer exists by email
}
