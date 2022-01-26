package com.webproject.zerosheet.customer;

import com.webproject.zerosheet.inventory.ProductDto;
import com.webproject.zerosheet.inventory.ProductRepository;
import com.webproject.zerosheet.inventory.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }


    public void addCustomer(CustomerDto customerDto){
        Customer c = new Customer();

        c.setFullName(customerDto.getFullName());
        c.setCommonNameAddress(customerDto.getCommonNameAddress());
        c.setCityAddress(customerDto.getCityAddress());
        c.setContactNo(customerDto.getContactNo());

        customerRepository.save(c);
    }

    public Customer getCustomer(long custID) {
        return customerRepository.findById(custID).get();
    }

    public void remCustomer(long custID){
        customerRepository.deleteById(custID);
    }
}
