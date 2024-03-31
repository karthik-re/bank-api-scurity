package org.example.bankapi.service;

import org.example.bankapi.entity.Account;
import org.example.bankapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getAccountById(int accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.orElse(null);
    }

    @Override
    public Account getAccountByCustomerId(int customerId) {
        Optional<Account> account = accountRepository.findByCustomerId(customerId);
        return account.orElse(null);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
