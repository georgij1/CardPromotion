package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.repoCard.Repository;
import jakarta.servlet.http.HttpServletResponse;
import org.openapi.example.model.CardTable;

public class StatusCard {
    public static void statusCard(
            Repository repository,
            HttpServletResponse response,
            CardTable customerCard
    ) {
        if (Boolean.TRUE.equals(repository.findByCardIdIncludeCard(String.valueOf(customerCard.getCardNumber())))) {
            IncludeCard.includeCard(repository, customerCard);
        }

        else if (Boolean.TRUE.equals(repository.findByCardIdYetIncludeCard(String.valueOf(customerCard.getCardNumber())))) {
            YetIncludeCard.yetIncludeCard(response);
        }

        else {
            NotFoundCard.notFoundCard(response);
        }
    }
}