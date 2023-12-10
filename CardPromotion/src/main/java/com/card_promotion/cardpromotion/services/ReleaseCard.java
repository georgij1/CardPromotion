package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReleaseCard {
    CardsRepository cardsRepository;

    public void releaseCard(String cardNumber, Integer idCustomer) {
        Boolean free = false;
        cardsRepository.updateCardByIdCustomerAndFree(idCustomer, free, cardNumber);
    }
}