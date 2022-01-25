package com.webproject.zerosheet.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public void addCustomer(Customer customer) {
        Optional<Customer> customerByName = customerRepository.findCustomerByName(customer.getCustName());

        if(customerByName.isPresent()){
            throw new IllegalStateException("Customer with name already exists!");
        }

        customerRepository.save(customer);
    }

    public void deleteCustomer(String custID) {
        boolean custExists = customerRepository.existsById(custID);

        if(!custExists){
            throw new IllegalStateException("Customer doesn't exist!");
        }

        customerRepository.deleteById(custID);
    }

    @Transactional
    public void updateStudent(String custID, String custName, String address, String contactNo) {
        Customer customer = customerRepository.findById(custID).orElseThrow(() -> new IllegalStateException(
                "Customer with ID " + custID + " doesn't exist"
        ));

        // ID is not empty & not the same ID; set the new ID
        if(custID != null && custID.length() > 0 && !Objects.equals(customer.getCustID(), custID)){
            Optional<Customer> customerByID = customerRepository.findCustomerByID(custID);
            if(customerByID.isPresent()){
                throw new IllegalStateException("Customer ID already taken");
            }
            customer.setCustID(custID);
        }
        if(custName != null && custName.length() > 0 && !Objects.equals(customer.getCustName(), custName)){
            Optional<Customer> customerByName = customerRepository.findCustomerByName(custName);
            if(customerByName.isPresent()){
                throw new IllegalStateException("Customer Name already taken");
            }
            customer.setCustName(custName);
        }
        if(address != null && address.length() > 0 && !Objects.equals(customer.getAddress(), address)){
            customer.setAddress(address);
        }
        if(contactNo != null && contactNo.length() > 0 && !Objects.equals(customer.getContactNo(), contactNo)){
            customer.setContactNo(contactNo);
        }
    }
}
