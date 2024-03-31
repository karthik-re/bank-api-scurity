package org.example.bankapi.repository;

import org.example.bankapi.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(int customerId);

}
