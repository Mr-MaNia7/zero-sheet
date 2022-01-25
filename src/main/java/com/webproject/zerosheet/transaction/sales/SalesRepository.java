package com.webproject.zerosheet.transaction.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

//    // Find Sales by Sales date
//    @Query("SELECT s from Sales WHERE DATE('date') = ?1")
//    Optional<Sales> findSalesByDate (LocalDate salesDate);


    // Find Sales by Customer ID
    @Query("SELECT s from Sales s WHERE s.custID = ?1")
    Optional <Sales> findSalesByCustomer (String custID);
}
