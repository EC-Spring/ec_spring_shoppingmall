package com.example.ec_spring_shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EcSpringShoppingmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcSpringShoppingmallApplication.class, args);
    }

}
