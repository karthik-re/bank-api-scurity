package org.example.bankapi.service;

import org.example.bankapi.entity.AccountTransaction;
import org.example.bankapi.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public TransactionServiceImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }
    @Override
    public void createTransaction(AccountTransaction transaction) {
        accountTransactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(int transactionId) {
        accountTransactionRepository.deleteById(transactionId);
    }

    @Override
    public void updateTransaction(AccountTransaction transaction) {
        accountTransactionRepository.save(transaction);
    }

    @Override
    public AccountTransaction getTransactionById(int transactionId) {
        Optional<AccountTransaction> transaction = accountTransactionRepository.findById(transactionId);
        return transaction.orElse(null);
    }

    @Override
    public List<AccountTransaction> getAllTransactions() {
        return accountTransactionRepository.findAll();
    }

    @Override
    public List<AccountTransaction> getTransactionsByCustomerId(int customerId) {
        return accountTransactionRepository.findByCustomerIdOrderByTransactionDateDesc(customerId);
    }
}
