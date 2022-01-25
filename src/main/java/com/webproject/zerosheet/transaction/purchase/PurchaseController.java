package com.webproject.zerosheet.transaction.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List <Purchase> getPurchases(){
        return purchaseService.getPurchases();
    }

    @GetMapping(path = "{vendID}")
    public Optional<Purchase> getPurchByVend(@PathVariable("vendID") String vendID){
        return purchaseService.getPurchaseByID(vendID);
    }

    @PostMapping
    public void newPurchase(@RequestBody Purchase purchase){
        purchaseService.addPurchase(purchase);
    }
}
