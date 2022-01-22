package com.webproject.zerosheet.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCust(){
        return customerService.getCust();
    }

//    @PostMapping
//    public void registerCust(@RequestBody Customer customer){
//        customerService.addCust(customer);
//    }
}
