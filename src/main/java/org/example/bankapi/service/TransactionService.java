package org.example.bankapi.service;

import org.example.bankapi.entity.AccountTransaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(AccountTransaction transaction);

    void deleteTransaction(int transactionId);

    void updateTransaction(AccountTransaction transaction);

    AccountTransaction getTransactionById(int transactionId);

    List<AccountTransaction> getAllTransactions();

    List<AccountTransaction> getTransactionsByCustomerId(int customerId);
}
