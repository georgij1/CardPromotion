package com.card_promotion.cardpromotion.services;

import jakarta.servlet.http.HttpServletResponse;

public class NotFoundCard {
    public static void notFoundCard(
            HttpServletResponse response
    ) {
        response.setStatus(404);
    }
}