package com.card_promotion.cardpromotion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFound extends RuntimeException {

    public ItemNotFound(String entityName, String id) {
        super("Item '" + entityName + "' with id '" + id + "' is not found");
    }
}
