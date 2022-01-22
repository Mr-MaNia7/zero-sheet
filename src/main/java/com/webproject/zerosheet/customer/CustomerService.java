package com.webproject.zerosheet.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCust(){

        return customerRepository.findAll();
    }

//    public void addCust(Customer customer) {
////        Optional<Customer> custByName = customerRepository.findCustomerbyCustName(customer.getCustName());
////
////        if(custByName.isPresent()){
////            throw new IllegalStateException("Customer already exists");
////        }
////        customerRepository.save(customer);
////    }
}
