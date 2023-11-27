package com.card_promotion.cardpromotion.services;

import com.card_promotion.cardpromotion.forms.SetCustomerCard;
import com.card_promotion.cardpromotion.repoCard.Repository;

public class IncludeCard {
    public static String includeCard(
            Repository repository,
            SetCustomerCard customerCard
    ) {
        repository.includeCard(customerCard.getCard_number());
        return "Теперь у карты есть хозяин";
    }
}