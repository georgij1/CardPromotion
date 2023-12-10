package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.exception.CardIsAlreadyOwned;
import com.card_promotion.cardpromotion.exception.ItemNotFound;
import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CardTableDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusCard {
    ReleaseCard releaseCard;
    CardsRepository repository;

    public void statusCard(CardTableDto customerCard) {

        Optional<Card> cardOptional = repository.findCardTableByCardNumber(String.valueOf(customerCard.getCardNumber()));

        if (cardOptional.isEmpty()) {
            throw new ItemNotFound("Card", customerCard.getCardNumber());
        }

        var card = cardOptional.get();

        if (!card.getFree()) {
            throw new CardIsAlreadyOwned(card.getCardNumber());
        }

        releaseCard.releaseCard(card.getCardNumber(), customerCard.getIdCustomer());
    }
}