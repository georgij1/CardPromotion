package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repository.Card;
import com.card_promotion.cardpromotion.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class GeneratedCard {
    CardsRepository repository;

    public void generatedCard(Integer generateCards) {
        Random random = new Random();
        int min = 100000;
        int max = 1000000000;
        for (int i = 0; i < generateCards; i++) {
            int randomNum = random.nextInt((max - min) + 1) + min;

            var card = new Card(null, true, String.valueOf(randomNum), null);

            repository.save(card);
        }
    }
}