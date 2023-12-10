package com.card_promotion.cardpromotion.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(chain = true)
@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("id_card")
    private Long idCard;
    @Column("free")
    private Boolean free;
    @Column("card_number")
    private String cardNumber;
    @Column("id_customer")
    private Integer idCustomer;
}