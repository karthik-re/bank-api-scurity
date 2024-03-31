package org.example.bankapi.repository;

import org.example.bankapi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartDateDesc(int customerId);
}
