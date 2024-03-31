package org.example.bankapi.controller;

import org.example.bankapi.entity.Card;
import org.example.bankapi.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards/")
public class CardsController {

    private final CardService cardService;

    @Autowired
    public CardsController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/myCard")
    public List<Card> getMyCard(@RequestParam int customerId) {
        return cardService.getCardByCustomerId(customerId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCard(@RequestBody Card card) {
        card.setCardId(0);
        cardService.createCard(card);
        return ResponseEntity.ok("Card created successfully");
    }
}
