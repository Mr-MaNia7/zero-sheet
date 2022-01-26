package com.webproject.zerosheet.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c from customers c WHERE c.contactNo = ?1")
    Customer findByContactNo (String contactNo);
}
