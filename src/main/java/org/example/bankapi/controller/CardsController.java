package org.example.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards/")
public class CardsController {

    @GetMapping("/myCard")
    public String getMyCard() {
        return "This is your card";
    }
}
