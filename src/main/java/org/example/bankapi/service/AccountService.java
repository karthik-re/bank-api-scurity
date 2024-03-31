package org.example.bankapi.service;

import org.example.bankapi.entity.Account;

import java.util.List;

public interface AccountService {

    void createAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    Account getAccountById(int accountId);

    Account getAccountByCustomerId(int customerId);

    List<Account> getAllAccounts();
}
