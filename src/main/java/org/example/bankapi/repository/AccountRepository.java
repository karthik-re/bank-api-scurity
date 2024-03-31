package org.example.bankapi.repository;

import org.example.bankapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByCustomerId(int customerId); // This method is used to find an account by customer id
}
