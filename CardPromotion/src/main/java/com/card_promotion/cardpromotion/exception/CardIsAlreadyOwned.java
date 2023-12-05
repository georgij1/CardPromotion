package com.card_promotion.cardpromotion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class CardIsAlreadyOwned extends RuntimeException {

    public CardIsAlreadyOwned(String id) {
        super("Card with id '" + id + "' is already owned");
    }
}