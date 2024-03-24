package org.example.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balance/")
public class BalanceController {

        @GetMapping("/myBalance")
        public String getMyBalance() {
            return "This is your balance";
        }


}
