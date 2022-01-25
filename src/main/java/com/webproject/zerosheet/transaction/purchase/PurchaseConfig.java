package com.webproject.zerosheet.transaction.purchase;

import com.webproject.zerosheet.vendor.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class PurchaseConfig {

    @Bean
    CommandLineRunner purchaseCommandLineRunner(PurchaseRepository purchaseRepository){
        return args -> {
            Purchase p1 = new Purchase(
                    LocalDate.of(2021, Month.DECEMBER, 1),
                    20000.00,
                    1500,
                    Category.RawMaterials,
                    "V001"
            );

            purchaseRepository.save(p1);
        };
    }
}
