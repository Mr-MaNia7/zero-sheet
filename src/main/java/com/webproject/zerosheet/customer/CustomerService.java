package com.webproject.zerosheet.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public List<Customer> getCust(){
        return List.of(
                new Customer(
                        "C001",
                        "EthioTelecom",
                        "Addis Ababa",
                        "0115111111"
                )
        );
    }
}
