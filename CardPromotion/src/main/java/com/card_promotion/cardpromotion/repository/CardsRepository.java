package com.card_promotion.cardpromotion.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CardsRepository extends ListCrudRepository<Card, Long> {
    Optional<Card> findCardTableByCardNumber(String cardNumber);

    Iterable<Card> findCardTablesByFree(Boolean free);

    @Modifying
    @Transactional
    @Query(value = "update card set id_customer=:idCustomer, free=:free where card_bonus_system.public.card.card_number=:CardNumber", nativeQuery = true)
    void updateCardByIdCustomerAndFree(Integer idCustomer, Boolean free, String CardNumber);
}