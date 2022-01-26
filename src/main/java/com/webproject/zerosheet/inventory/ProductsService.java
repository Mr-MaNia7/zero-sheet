package com.webproject.zerosheet.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepo;

    public List<Products> getAll(){
        return productRepo.findAll();
    }


    public void addProduct(ProductDto productDto){
        Products product = new Products();

        product.setProdName(productDto.getProdName());
        product.setProdType(productDto.getProdType());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setState(productDto.getState());

        productRepo.save(product);
    }

    public Products getProd(long prodID) {
        return productRepo.findById(prodID).get();
    }

    public void remProduct(long prodID){
        productRepo.deleteById(prodID);
    }

}
