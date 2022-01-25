package com.webproject.zerosheet.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner customerCommandLineRunner(CustomerRepository customerRepository){
        return args -> {
            //Test case customer objects
            Customer c1= new Customer(
                    "C001",
                    "EthioTelecom",
                    "Addis Ababa",
                    "0911111111"
            );
            Customer c2 = new Customer(
                    "C002",
                    "SafariCom",
                    "Nairobi",
                    "0922222222"
            );

            customerRepository.saveAll(List.of(c1, c2));
        };
    }
}
