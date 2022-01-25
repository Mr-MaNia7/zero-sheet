package com.webproject.zerosheet.transaction.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getPurchases(){
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchaseByID(String vendID){
        return purchaseRepository.findPurchaseByVendor(vendID);
    }

    public void addPurchase(Purchase purchase){
        purchaseRepository.save(purchase);
    }
}
