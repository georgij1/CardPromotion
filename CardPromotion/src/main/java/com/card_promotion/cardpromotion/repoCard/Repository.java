package com.card_promotion.cardpromotion.repoCard;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface Repository extends CrudRepository<CardTable, Long> {
    @Transactional
    @Query("select exists(select card from CardTable card where card.card_number=:cardNumber and card.free=true)")
    boolean findByCardIdIncludeCard(String cardNumber);

    @Transactional
    @Query("select exists(select card from CardTable card where card.card_number=:cardNumber and card.free=false)")
    boolean findByCardIdYetIncludeCard(String cardNumber);

    @Transactional
    @Modifying
    @Query("update CardTable card set card.free=false where card.card_number=:cardNumber")
    void includeCard(String cardNumber);

    @Transactional
    @Query("select card from CardTable card where card.id_card=:cardId")
    List<?> findByCardId(Integer cardId);

    @Transactional
    @Query("select card from CardTable card where card.card_number=:cardNumber")
    List<?> findByCardNumber(String cardNumber);

    @Transactional
    @Query("select card from CardTable card where card.free=:free")
    List<?> findByStatusFree(Boolean free);

    @Transactional
    @Modifying
    @Query(value="insert into card(free, card_number) values(true, :cardNumber)", nativeQuery = true)
    void generateCards(String cardNumber);
}