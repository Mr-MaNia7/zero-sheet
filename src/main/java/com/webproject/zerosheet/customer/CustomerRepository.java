package com.webproject.zerosheet.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT c from Customer c WHERE c.custName = ?1")
    Optional<Customer> findCustomerByName (String custName);

    @Query("Select c from Customer c WHERE c.custID = ?1")
    Optional<Customer> findCustomerByID (String custID);
}
