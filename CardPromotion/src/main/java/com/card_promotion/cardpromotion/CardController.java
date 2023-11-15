package com.card_promotion.cardpromotion;

import com.card_promotion.cardpromotion.forms.GenerateCards;
import com.card_promotion.cardpromotion.forms.SetCustomerCard;
import com.card_promotion.cardpromotion.repo.CardRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
@RequestMapping("card")
@AllArgsConstructor
@Tag(name = "Карта", description = "Бонусная Карта клиента")
public class CardController {
    JdbcTemplate jdbcTemplate;
    @Autowired
    CardRepo cardRepo;

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
        if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select * from card_bonus_system.public.card where card_number=? and free=true)", Boolean.class, customerCard.getCard_number()))) {
//            jdbcTemplate.update("update card_bonus_system.public.card set free=false where card_number=?", customerCard.getCard_number());
            cardRepo.updateFreeBy(customerCard.getCard_number());
            return "Карта привязана к пользователю её номер - " + customerCard.getCard_number();
        }

        else if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select * from card_bonus_system.public.card where card_number=? and free=false)", Boolean.class, customerCard.getCard_number()))) {
            response.setStatus(203);
            return "Карта уже подключена";
        }

        else {
            response.setStatus(404);
            return "Такой карты нет";
        }
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
        Random random = new Random();
        int min = 100000;
        int max = 1000000000;
        for (int i = 0; i < generateCards.getCount_cards(); i++) {
            int randomNum = random.nextInt((max - min) + 1) + min;
            System.out.println(randomNum);
            jdbcTemplate.update("insert into card_bonus_system.public.card(free, card_number) VALUES (true, ?)", randomNum);
        }
        return "Рандомные карты сгенерированы";
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
        return jdbcTemplate.queryForList("select * from card_bonus_system.public.card where id_card=?", idCard).toString();
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
        return jdbcTemplate.queryForList("select * from card_bonus_system.public.card where card_number=?", CardNumber).toString();
    }

    @GetMapping("/GetFreeCards")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "GetFreeCard",
            description = "Получаем свободные карты"
    )
    public String GetFreeCards () {
        return jdbcTemplate.queryForList("select * from card_bonus_system.public.card where free=true").toString();
    }
}