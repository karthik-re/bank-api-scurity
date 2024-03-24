package org.example.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notices/")
public class NoticesController {

    @GetMapping("/myNotice")
    public String getMyNotice() {
        return "This is your notice";
    }
}
