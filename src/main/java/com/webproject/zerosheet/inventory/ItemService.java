package com.webproject.zerosheet.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository productRepo;

    public List<Item> getAll(){
        return productRepo.findAll();
    }


    public void addProduct(ItemDto productDto){
        Item product = new Item();

        product.setName(productDto.getName());
        product.setUnit(productDto.getUnit());
        product.setExpectedArea(productDto.getExpectedArea());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setTotalQuantity(productDto.getTotalQuantity());
        product.setLoanquant(productDto.getLoanquant());
        product.setMaintenancequant(productDto.getMaintenancequant());

        productRepo.save(product);
    }

    public Item getProd(Long prodID) {
        return productRepo.findById(prodID).get();
    }

    public void remProduct(Long prodID){
        productRepo.deleteById(prodID);
    }

}
