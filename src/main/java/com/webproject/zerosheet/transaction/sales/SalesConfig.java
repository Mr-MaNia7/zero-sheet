package com.webproject.zerosheet.transaction.sales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class SalesConfig {

    @Bean
    // Testing DB connection using mock data
    CommandLineRunner salesCommandLineRunner(SalesRepository salesRepository){
        return args -> {
            Sales s1 = new Sales(
                    LocalDate.of(2021, Month.DECEMBER, 1),
                    "C001",
                    15000,
                    0.15,
                    15
            );
            salesRepository.save(s1);
        };
    }
}
