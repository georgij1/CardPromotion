package com.card_promotion.cardpromotion.controllers;

import com.card_promotion.cardpromotion.forms.GenerateCards;
import com.card_promotion.cardpromotion.forms.SetCustomerCard;
import com.card_promotion.cardpromotion.repoCard.Repository;
import com.card_promotion.cardpromotion.services.GeneratedCard;
import com.card_promotion.cardpromotion.services.StatusCard;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
@AllArgsConstructor
@Tag(name = "Карта", description = "Бонусная Карта клиента")
public class CardController {
    public Repository repository;

    @PostMapping("/createCard")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Регистрация карты клиента",
            description = "Позволяет зарегистрировать карту клиента"
    )
    @SneakyThrows
    public String SetCustomerCard(
            @RequestBody SetCustomerCard customerCard,
            HttpServletResponse response
    ) {
        return StatusCard.statusCard(repository, response, customerCard);
    }

    @PostMapping("/generateCards")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Генератор карт",
            description = "Генерируем карты, чтобы их было бесконечное колл-во"
    )
    public String GenerateCards(
            @RequestBody GenerateCards generateCards
    ) {
        return GeneratedCard.generatedCard(generateCards, repository);
    }

    @GetMapping("/idCard/{idCard}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "idCardGet",
            description = "Получаем карту по id карты"
    )
    public String GetCardById(
            @PathVariable("idCard") Integer idCard
    ) {
        return repository.findByCardId(idCard).toString();
    }

    @GetMapping("/CardNumber/{CardNumber}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "CardNumberGet",
            description = "Получаем карту по номеру карты"
    )
    public String GetCardByNumber(
            @PathVariable("CardNumber") String CardNumber
    ) {
        return repository.findByCardNumber(CardNumber).toString();
    }

    @GetMapping("/GetFreeCards")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "GetFreeCard",
            description = "Получаем свободные карты"
    )
    public String GetFreeCards () {
        return repository.findByStatusFree(true).toString();
    }
}