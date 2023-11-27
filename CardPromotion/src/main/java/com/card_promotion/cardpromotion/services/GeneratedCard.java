package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.forms.GenerateCards;
import com.card_promotion.cardpromotion.repoCard.CardTable;
import com.card_promotion.cardpromotion.repoCard.Repository;
import java.util.Random;

public class GeneratedCard {
    public static String generatedCard(
            GenerateCards generateCards,
            Repository repository
    ) {
        Random random = new Random();
        int min = 100000;
        int max = 1000000000;
        for (int i = 0; i < generateCards.getCount_cards(); i++) {
            int randomNum = random.nextInt((max - min) + 1) + min;
            repository.generateCards(String.valueOf(randomNum));
        }
        return "Рандомные карты сгенерированы";
    }
}