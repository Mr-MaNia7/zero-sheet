package com.webproject.zerosheet.inventory.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT s FROM sales s WHERE salesDate BETWEEN ?1 AND ?2")
    Sales findByDate(LocalDate startDate, LocalDate endDate);
}
