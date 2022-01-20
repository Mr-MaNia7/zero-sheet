package com.webproject.zerosheet.vendor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    public List<Vendor> getVend(){
        return List.of(new Vendor());
    }
}
