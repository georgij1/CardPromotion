package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PostInfo {
    public CardsRepository repository;

    public void generatedCard(Integer generateCards) {
        for (int i = 0; i < generateCards; i++) {
            var card = new Card(null, true, String.valueOf(UUID.randomUUID()), null);
            repository.save(card);
        }
    }
}