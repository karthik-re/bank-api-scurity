package org.example.bankapi.service;

import org.example.bankapi.entity.Loan;

import java.util.List;

public interface LoanService {

    void createLoan(Loan loan);

    Loan getLoanById(int loanId);

    void deleteLoan(int loanId);

    void updateLoan(Loan loan);

    List<Loan> getMyLoan(int customerId);
}
