package org.example.bankapi.service;

import org.example.bankapi.entity.Loan;
import org.example.bankapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    @Override
    public void createLoan(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(int loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        return loan.orElse(null);
    }

    @Override
    public void deleteLoan(int loanId) {
        loanRepository.deleteById(loanId);
    }

    @Override
    public void updateLoan(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public List<Loan> getMyLoan(int customerId) {
        return  loanRepository.findByCustomerIdOrderByStartDateDesc(customerId);
    }
}
