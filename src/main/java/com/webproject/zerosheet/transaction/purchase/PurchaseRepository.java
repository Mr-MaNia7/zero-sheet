package com.webproject.zerosheet.transaction.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT pr from Purchases pr WHERE pr.vendID = ?1")
    Optional<Purchase> findPurchaseByVendor (String vendID);

    @Query("SELECT pr from Purchases pr WHERE DATE('date') = ?1")
    Optional<Purchase> findPurchaseByDate (LocalDate purchaseDate);
}
