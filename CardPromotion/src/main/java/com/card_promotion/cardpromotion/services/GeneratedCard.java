package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repoCard.Repository;

import java.util.Random;

public class GeneratedCard {
    public static void generatedCard(
            Integer generateCards,
            Repository repository
    ) {
        Random random = new Random();
        int min = 100000;
        int max = 1000000000;
        for (int i = 0; i < generateCards; i++) {
            int randomNum = random.nextInt((max - min) + 1) + min;
            repository.generateCards(String.valueOf(randomNum));
        }
    }
}