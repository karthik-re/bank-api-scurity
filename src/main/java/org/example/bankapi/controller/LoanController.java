package org.example.bankapi.controller;

import org.example.bankapi.entity.Loan;
import org.example.bankapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans/")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping("/myLoan")
    public ResponseEntity<List<Loan>> getMyLoan(@RequestParam int customerId) {

        return ResponseEntity.ok().body(loanService.getMyLoan(customerId));
    }
    @PostMapping("/addLoan")
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        loanService.createLoan(loan);
        return ResponseEntity.ok().body(loan);
    }
}
