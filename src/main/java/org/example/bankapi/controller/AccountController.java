package org.example.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

    @GetMapping("/myAccount")
    public String getMyAccount() {
        return "This is your account";
    }


}
