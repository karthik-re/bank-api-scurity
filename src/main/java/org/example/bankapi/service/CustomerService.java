package org.example.bankapi.service;

import org.example.bankapi.DTO.RegisterDTO;
import org.example.bankapi.entity.Customer;

import java.util.List;

public interface CustomerService {

    void createCustomer(RegisterDTO registerDTO);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    Customer getCustomerByEmail(String email);

    boolean existsByEmail(String email);

    List<Customer> getAllCustomers();
}
