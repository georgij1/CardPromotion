package com.card_promotion.cardpromotion.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardRepo extends CrudRepository<CardTable, Long> {
    @Transactional
    @Modifying
    @Query("update CardTable c set c.free = false where CardTable.card_number=:cardNumber")
    void updateFreeBy(String cardNumber);
}