package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CardTableDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FindFreeCards {
    CardsRepository repository;

    public List<CardTableDto> findFreeCards() {
        Iterable<Card> cards = repository.findCardTablesByFree(true);
        List<CardTableDto> cardsDto = new ArrayList<CardTableDto>();

        for (Card card : cards) {
            cardsDto.add(new CardTableDto(card.getFree(), card.getCardNumber(), card.getIdCustomer()));
        }

        return cardsDto;
    }
}
