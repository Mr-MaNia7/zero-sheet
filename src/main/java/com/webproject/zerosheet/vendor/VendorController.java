package com.webproject.zerosheet.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "vendors")
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

    @PostMapping
    public void newVendor(@RequestBody Vendor vendor){
        vendorService.addVendor(vendor);
    }

    @DeleteMapping(path = "{vendID}")
    public void remVendor(@PathVariable("vendID") String vendID){
        vendorService.deleteCustomer(vendID);
    }

    @PutMapping(path = "{vendID}")
    public void updateVendor(@PathVariable("vendID") String vendID,
                             @RequestParam(required = true) String vendName,
                             @RequestParam(required = true) String bankAcc,
                             @RequestParam(required = false) String address,
                             @RequestParam (required = false) Category category){
        vendorService.updateVendor(vendID, vendName, bankAcc, address, category);
    }
}
