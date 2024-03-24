package org.example.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts/")
public class ContactController {

    @GetMapping("/myContact")
    public String getMyContact() {
        return "This is your contact";
    }
}
