package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.forms.SetCustomerCard;
import com.card_promotion.cardpromotion.repoCard.Repository;
import jakarta.servlet.http.HttpServletResponse;

public class StatusCard {
    public static String statusCard(
            Repository repository,
            HttpServletResponse response,
            SetCustomerCard customerCard
    ) {
        if (Boolean.TRUE.equals(repository.findByCardIdIncludeCard(customerCard.getCard_number()))) {
            return IncludeCard.includeCard(repository, customerCard);
        }

        else if (Boolean.TRUE.equals(repository.findByCardIdYetIncludeCard(customerCard.getCard_number()))) {
            return YetIncludeCard.yetIncludeCard(response);
        }

        else {
            return NotFoundCard.notFoundCard(response);
        }
    }
}