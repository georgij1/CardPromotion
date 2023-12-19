package com.card_promotion.cardpromotion.controllers.v1;

import com.card_promotion.cardpromotion.services.*;
import lombok.AllArgsConstructor;
import org.openapi.example.api.CardCustomerApi;
import org.openapi.example.model.CardTableDto;
import org.openapi.example.model.GenerateCardsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController implements CardCustomerApi {
    private Service service;

    @Override
    public ResponseEntity<Void> generateCustomerCard(GenerateCardsDto generateCards) {
        service.generatedCard(generateCards.getCountCards());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> includeCustomerCard(CardTableDto cardTable) {
        service.statusCard(cardTable);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CardTableDto> cardId(Long idCard) {
        var getByCardId = service.findByCardId(idCard);
        return ResponseEntity.ok().body(getByCardId);
    }

    @Override
    public ResponseEntity<CardTableDto> cardNumber(String cardNumber) {
        String cardNumberStr = String.valueOf(cardNumber);
        var getByCardNumber = service.findByCardNumber(cardNumberStr);
        return ResponseEntity.ok().body(getByCardNumber);
    }

    @Override
    public ResponseEntity<List<CardTableDto>> getFreeCards() {
        var getFreeCards = service.findFreeCards();
        return ResponseEntity.ok().body(getFreeCards);
    }

    @Override
    public ResponseEntity<Void> halfCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}