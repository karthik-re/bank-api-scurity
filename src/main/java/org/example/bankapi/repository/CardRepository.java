package org.example.bankapi.repository;

import org.example.bankapi.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByCustomerId(int customerId); // This method is used to find a card by account id
}
