package com.webproject.zerosheet.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customers")
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

    @PostMapping
    public void newCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @DeleteMapping(path = "{custID}")
    public void remCustomer(@PathVariable("custID") String custID){
        customerService.deleteCustomer(custID);
    }

    @PutMapping(path = "{custID}")
    public void updateCustomer(@PathVariable("custID") String custID,
                               @RequestParam(required = false) String custName,
                               @RequestParam(required = false) String address,
                               @RequestParam(required = false) String contactNo){
        customerService.updateStudent(custID, custName, address, contactNo);
    }

}
