package org.example.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans/")
public class LoanController {

    @GetMapping("/myLoan")
    public String getMyLoan() {
        return "This is your loan";
    }

    
}
