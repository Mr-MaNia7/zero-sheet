package com.webproject.zerosheet.vendor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

    @Query("SELECT v from Vendors v WHERE v.vendID = ?1")
    Optional<Vendor> findVendorByID(String vendID);

    @Query("SELECT v from Vendors v WHERE v.vendName = ?1")
    Optional<Vendor> findVendorByName(String vendName);

    @Query ("SELECT v from Vendors v WHERE v.bankAcc = ?1")
    Optional<Vendor> findVendorByAcc(String bankAcc);
}
