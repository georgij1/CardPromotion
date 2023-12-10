package com.card_promotion.cardpromotion.controllers.v1;

import com.card_promotion.cardpromotion.services.*;
import jakarta.servlet.http.HttpServletResponse;
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
    private FindByCardId findByCardId;
    private FindByCardNumber findByCardNumber;
    private FindFreeCards findFreeCards;
    private StatusCard statusCard;
    private GeneratedCard generatedCard;

    HttpServletResponse response;

    @Override
    public ResponseEntity<Void> generateCustomerCard(GenerateCardsDto generateCards) {
        generatedCard.generatedCard(generateCards.getCountCards());
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> includeCustomerCard(CardTableDto cardTable) {
        statusCard.statusCard(cardTable);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CardTableDto> cardId(Long idCard) {
        return ResponseEntity.ok().body(findByCardId.findByCardId(idCard));
    }

    @Override
    public ResponseEntity<CardTableDto> cardNumber(Integer cardNumber) {
        return ResponseEntity.ok().body(findByCardNumber.findByCardNumber(String.valueOf(cardNumber)));
    }

    @Override
    public ResponseEntity<List<CardTableDto>> getFreeCards() {
        return ResponseEntity.ok().body(findFreeCards.findFreeCards());
    }
}