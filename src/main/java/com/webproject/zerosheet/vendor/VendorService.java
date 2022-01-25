package com.webproject.zerosheet.vendor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    // Displaying all vendors
    public VendorService(VendorRepository vendorRepository){
        this.vendorRepository = vendorRepository;
    }
    public List<Vendor> getVend(){
        return vendorRepository.findAll();
    }

    // Add new Vendor method
    public void addVendor(Vendor vendor) {
        Optional<Vendor> vendorByID = vendorRepository.findVendorByID(vendor.getVendID());
        Optional<Vendor> vendorByName = vendorRepository.findVendorByName(vendor.getVendName());
        Optional<Vendor> vendorByAcc = vendorRepository.findVendorByAcc(vendor.getBankAcc());

        if (vendorByID.isPresent()){
            throw new IllegalStateException("Vendor with ID already exists!");
        }
        if(vendorByName.isPresent()){
            throw new IllegalStateException("Vendor with name already exists!");
        }
        if(vendorByAcc.isPresent()){
            throw new IllegalStateException("Vendor with bank account already exists!");
        }

        vendorRepository.save(vendor);
    }

    // Delete Vendor method using ID
    public void deleteCustomer(String vendID) {
        boolean vendExists = vendorRepository.existsById(vendID);

        if(!vendExists){
            throw new IllegalStateException("Vendor doesn't exist!");
        }

        vendorRepository.deleteById(vendID);
    }

    @Transactional
    public void updateVendor(String vendID, String vendName, String bankAcc, String address, Category category) {

        // Check if the vendor exists
        Vendor vendor = vendorRepository.findById(vendID).orElseThrow(() -> new IllegalStateException(
                "Vendor with ID " + vendID + " doesn't exist"
        ));

        // ID is not empty & not the same ID; set the new ID
        if(vendID != null && vendID.length() > 0 && !Objects.equals(vendor.getVendID(), vendID)){
            Optional<Vendor> vendorByID = vendorRepository.findVendorByID(vendID);
            if(vendorByID.isPresent()){
                throw new IllegalStateException("Vendor ID already taken");
            }
            vendor.setVendID(vendID);
        }

        // Name is not empty & not the same name; set the new name
        if(vendName != null && vendName.length() > 0 && !Objects.equals(vendor.getVendName(), vendName)){
            Optional<Vendor> vendorByName = vendorRepository.findVendorByName(vendName);
            if(vendorByName.isPresent()){
                throw new IllegalStateException("Vendor Name already taken");
            }
            vendor.setVendName(vendName);
        }

        // BankAcc is not empty & not the same bankAcc; set the new bankAcc
        if(bankAcc != null && bankAcc.length() > 0 && !Objects.equals(vendor.getBankAcc(), bankAcc)){
            Optional<Vendor> vendorByAcc = vendorRepository.findVendorByAcc(bankAcc);
            if(vendorByAcc.isPresent()){
                throw new IllegalStateException("Vendor Bank Account already taken");
            }
            vendor.setBankAcc(bankAcc);
        }

        // Address is not empty & not the same address; set the new address
        if(address != null && address.length() > 0 && !Objects.equals(vendor.getAddress(), address)){
            vendor.setAddress(address);
        }

        // Category is not empty; set new category
        if(category != null && !Objects.equals(vendor.getCategory(), category)){
            vendor.setCategory(category);
        }
    }
}
