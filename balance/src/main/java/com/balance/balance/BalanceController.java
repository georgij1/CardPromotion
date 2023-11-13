package com.balance.balance;

import com.balance.balance.forms.SetBalance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("balance")
@AllArgsConstructor
@Tag(name = "Карта", description = "Бонусная Карта клиента")
public class BalanceController {
    JdbcTemplate jdbcTemplate;

    @PostMapping("/setBalance")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "setBalance",
            description = "Добавление баланса"
    )
    public int setBalance(@RequestBody SetBalance setBalance) {
        return jdbcTemplate.update("insert into balance_bonus_system.public.balance(id_client, balance) VALUES (?, ?)", setBalance.getId_client(), setBalance.getBalance());
    }

    @GetMapping("/getByClientID/{idClient}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Balance",
            description = "Получение баланса по idClient"
    )
    public String getByClientID(
            @PathVariable("idClient") String idClient
    ) {
        return jdbcTemplate.queryForList("select * from balance_bonus_system.public.balance where id_client=?", idClient).toString();
    }
}