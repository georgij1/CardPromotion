package com.card_promotion.cardpromotion.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CardTable {
    @Id
    private Long id_card;
    private Boolean free;
    private String card_number;
}