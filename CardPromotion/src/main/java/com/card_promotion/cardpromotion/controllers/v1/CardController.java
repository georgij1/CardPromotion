package com.card_promotion.cardpromotion.controllers.v1;

import com.card_promotion.cardpromotion.repoCard.Repository;
import com.card_promotion.cardpromotion.services.GeneratedCard;
import com.card_promotion.cardpromotion.services.StatusCard;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.openapi.example.api.CardCustomerApi;
import org.openapi.example.model.CardTable;
import org.openapi.example.model.GenerateCards;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("card")
@AllArgsConstructor
public class CardController implements CardCustomerApi {
    public Repository repository;
    HttpServletResponse response;

    @Override
    public ResponseEntity<List<GenerateCards>> generateCustomerCard(GenerateCards generateCards) {
        GeneratedCard.generatedCard(generateCards.getCountCards(), repository);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CardTable>> includeCustomerCard(CardTable cardTable) {
        StatusCard.statusCard(repository, response, cardTable);
        return ResponseEntity.ok().body(List.of(cardTable));
    }

    @Override
    public ResponseEntity<List<CardTable>> cardId(Integer idCard) {
        ArrayList<CardTable> arrayList = new ArrayList<>();
        arrayList.add(repository.findByCardId(idCard));
        return ResponseEntity.ok().body(arrayList);
    }

    @Override
    public ResponseEntity<List<CardTable>> cardNumber(Integer cardNumber) {
        ArrayList<CardTable> arrayList = new ArrayList<>();
        arrayList.add(repository.findByCardNumber(String.valueOf(cardNumber)));
        return ResponseEntity.ok().body(arrayList);
    }

    @Override
    public ResponseEntity<List<CardTable>> getFreeCards() {
        List<CardTable> arrayList = List.of(repository.findCardTableByFree(true));
        return ResponseEntity.ok().body(Collections.singletonList(arrayList.get(0)));
    }

    @Component
    public static class CustomConverter implements Converter<com.card_promotion.cardpromotion.repoCard.CardTable, CardTable>, com.card_promotion.cardpromotion.controllers.v1.CardConverter {
        @Override
        public org.openapi.example.model.CardTable convert(com.card_promotion.cardpromotion.repoCard.CardTable source) {
            return new CardTable();
        }
    }
}