package com.card_promotion.cardpromotion.forms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SetCustomerCard {
    @Schema(description = "card_number", example = "124523")
    public String card_number;
}