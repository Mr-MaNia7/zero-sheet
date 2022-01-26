package com.webproject.zerosheet.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

//    @Query("SELECT p from products p WHERE p.prodType = ?1")
//    Products findByType(String prodType);
}
