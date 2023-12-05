package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CardTableDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByCardNumber {
    public CardsRepository repository;

    public CardTableDto findByCardNumber(String cardNumber) {
        Optional<Card> cardOptional = repository.findCardTableByCardNumber(cardNumber);

        if (cardOptional.isEmpty()) {
            throw new RuntimeException("Card is not found");
        }

        var card = cardOptional.get();

        return new CardTableDto(card.getFree(), card.getCardNumber(), card.getIdCustomer());
    }
}
