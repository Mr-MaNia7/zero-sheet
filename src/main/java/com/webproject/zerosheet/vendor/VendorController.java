package com.webproject.zerosheet.vendor;

import com.webproject.zerosheet.customer.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService){
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getVend(){
        return vendorService.getVend();
    }
}
