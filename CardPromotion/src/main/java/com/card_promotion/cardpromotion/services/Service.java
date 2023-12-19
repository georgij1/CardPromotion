package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.exception.CardIsAlreadyOwned;
import com.card_promotion.cardpromotion.exception.ItemNotFound;
import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CardTableDto;

import java.util.*;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    public CardsRepository repository;

    public CardTableDto findByCardId(Long cardId) {
        Optional<Card> cardOptional = repository.findById(cardId);
        if (cardOptional.isPresent()) {
            var card = cardOptional.get();
            return new CardTableDto(card.getFree(), card.getCardNumber(), card.getIdCustomer());
        }
        else {
            throw new ItemNotFound("Card ", String.valueOf(cardId));
        }
    }

    public CardTableDto findByCardNumber(String cardNumber) {
        Optional<Card> cardOptional = repository.findCardTableByCardNumber(cardNumber);
        if (cardOptional.isPresent()) {
            var card = cardOptional.get();
            return new CardTableDto(card.getFree(), card.getCardNumber(), card.getIdCustomer());
        }
        else {
            throw new ItemNotFound("Card", cardNumber);
        }
    }

    public List<CardTableDto> findFreeCards() {
        Iterable<Card> cards = repository.findCardTablesByFree(true);
        List<CardTableDto> cardsDto = new ArrayList<>();
        for (Card card : cards) {
            cardsDto.add(new CardTableDto(card.getFree(), card.getCardNumber(), card.getIdCustomer()));
        }
        return cardsDto;
    }

    public void releaseCard(String cardNumber, Integer idCustomer) {
        Boolean free = false;
        repository.updateCardByIdCustomerAndFree(idCustomer, free, cardNumber);
    }

    public void statusCard(CardTableDto customerCard) {
        Optional<Card> cardOptional = repository.findCardTableByCardNumber(String.valueOf(customerCard.getCardNumber()));
        if (cardOptional.isEmpty()) {
            throw new ItemNotFound("Card", customerCard.getCardNumber());
        }
        var card = cardOptional.get();
        if (!card.getFree()) {
            throw new CardIsAlreadyOwned(card.getCardNumber());
        }
        releaseCard(card.getCardNumber(), customerCard.getIdCustomer());
    }

    public void generatedCard(Integer generateCards) {
        for (int i = 0; i < generateCards; i++) {
            var card = new Card(null, true, String.valueOf(UUID.randomUUID()), null);
            repository.save(card);
        }
    }
}