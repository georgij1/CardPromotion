package com.card_promotion.cardpromotion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends CrudRepository<Card, Long> {
    Optional<Card> findCardTableByCardNumber(String cardNumber);

    Iterable<Card> findCardTablesByFree(Boolean free);
}