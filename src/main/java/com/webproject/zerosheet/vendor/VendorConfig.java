package com.webproject.zerosheet.vendor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VendorConfig {

    @Bean
    CommandLineRunner vendorCommandLineRunner(VendorRepository vendorRepository){
        return args -> {
            //Test case customer objects
            Vendor v1= new Vendor(
                    "V001",
                    "EthioTelecom",
                    "CBE-10001313133",
                    Category.Communication,
                    "Addis Ababa"
            );

            vendorRepository.save(v1);
        };
    }
}
