package org.example.bankapi.controller;

import org.example.bankapi.entity.Account;
import org.example.bankapi.repository.AccountRepository;
import org.example.bankapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/myAccount")
    public ResponseEntity<Account> getMyAccount(@RequestParam int customerId) {
        return ResponseEntity.ok(accountService.getAccountByCustomerId(customerId));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        account.setAccountNumber(0);
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created successfully");
    }


}
