package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CardTableDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByCardId {
    public CardsRepository repository;

    public CardTableDto findByCardId(Long cardId) {
        Optional<Card> cardOptional = repository.findById(cardId);

        if (cardOptional.isEmpty()) {
            throw new RuntimeException("Card is not found");
        }

        var card = cardOptional.get();

        return new CardTableDto(card.getFree(), card.getCardNumber(), card.getIdCustomer());
    }
}
