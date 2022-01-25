package com.webproject.zerosheet.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p from Products p WHERE p.productID = ?1")
    Optional<Product> findProductByID(Long productID);

    @Query("SELECT p from Products p WHERE p.productName = ?1")
    Optional<Product> findProductByName(String productName);

}
