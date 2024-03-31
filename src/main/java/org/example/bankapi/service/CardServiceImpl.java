package org.example.bankapi.service;

import org.example.bankapi.entity.Card;
import org.example.bankapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public void createCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public List<Card> getCardByCustomerId(int customerId) {
        return cardRepository.findByCustomerId(customerId);
    }

    @Override
    public void deleteCard(int cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
