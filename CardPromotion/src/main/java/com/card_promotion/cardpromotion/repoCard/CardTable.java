package com.card_promotion.cardpromotion.repoCard;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "card")
@Data
public class CardTable extends org.openapi.example.model.CardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_card;
    @Column(name = "free")
    private Boolean free;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "id_customer")
    private Integer idCustomer;
}