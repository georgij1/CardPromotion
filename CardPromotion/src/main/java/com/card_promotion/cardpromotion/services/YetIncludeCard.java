package com.card_promotion.cardpromotion.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

public class YetIncludeCard {
    @SneakyThrows
    public static void yetIncludeCard(
            HttpServletResponse response
    ) {
        response.setStatus(203);
    }
}