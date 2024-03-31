package org.example.bankapi.controller;

import org.example.bankapi.entity.AccountTransaction;
import org.example.bankapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balance/")
public class BalanceController {

        private final TransactionService transactionService;

        @Autowired
        public BalanceController(TransactionService transactionService) {
            this.transactionService = transactionService;
        }

        @GetMapping("/getBalance")
        public ResponseEntity<List<AccountTransaction>> getBalance(@RequestParam int customerId) {
            return ResponseEntity.ok(transactionService.getTransactionsByCustomerId(customerId));
        }

        @PostMapping("/create")
        public ResponseEntity<String> createTransaction(@RequestBody AccountTransaction transaction) {
            transaction.setTransactionId(0);
            transactionService.createTransaction(transaction);
            return ResponseEntity.ok("Transaction created successfully");
        }
}
