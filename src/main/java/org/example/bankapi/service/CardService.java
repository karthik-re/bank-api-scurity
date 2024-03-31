package org.example.bankapi.service;

import org.example.bankapi.entity.Card;

import java.util.List;

public interface CardService {

    void createCard(Card card);

    List<Card> getCardByCustomerId(int customerId);

    void deleteCard(int cardId);

    void updateCard(Card card);

    List<Card> getAllCards();
}
