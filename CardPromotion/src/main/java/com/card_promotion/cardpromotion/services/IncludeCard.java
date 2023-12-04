package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repoCard.Repository;
import org.openapi.example.model.CardTable;

public class IncludeCard {
    public static void includeCard(
            Repository repository,
            CardTable customerCard
    ) {
        repository.includeCard(String.valueOf(customerCard.getCardNumber()), customerCard.getIdCustomer());
    }
}