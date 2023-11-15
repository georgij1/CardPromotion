package com.card_promotion.cardpromotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CardPromotionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardPromotionApplication.class, args);
    }

}
