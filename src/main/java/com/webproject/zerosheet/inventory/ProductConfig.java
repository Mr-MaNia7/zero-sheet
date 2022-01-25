package com.webproject.zerosheet.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository productRepository){
        return args -> {
            Product pr1 = new Product(
                    "PR001",
                    "HP-LaserJet Printer",
                    State.Available,
                    36,
                    8300
            );

            productRepository.save(pr1);
        };
    }
}
