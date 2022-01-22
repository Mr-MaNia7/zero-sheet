package com.webproject.zerosheet.vendor;

import com.webproject.zerosheet.customer.Customer;
import com.webproject.zerosheet.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository){
        this.vendorRepository = vendorRepository;
    }
    public List<Vendor> getVend(){
        return vendorRepository.findAll();
    }
}
