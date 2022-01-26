package com.webproject.zerosheet.inventory.sales;

import com.webproject.zerosheet.inventory.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private SalesRepository salesRepo;

    public SalesService(SalesRepository salesRepo) {
        this.salesRepo = salesRepo;
    }

    public List<Sales> getAll() {
        return salesRepo.findAll();
    }

    public void addSales(SalesDto salesDto) {
        Sales s = new Sales();

        s.setSalesDate(salesDto.getSalesDate());
        s.setCustID(salesDto.getCustID());
        s.setAmount(salesDto.getAmount());
        s.setTax(salesDto.getTax());
        s.setQty(salesDto.getQty());

        salesRepo.save(s);
    }

    public void remSales(long salesID){
        salesRepo.deleteById(salesID);
    }
}
