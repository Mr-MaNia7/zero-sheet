package com.webproject.zerosheet.transaction.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;


    @Autowired
    public SalesService(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    public List<Sales> getSales(){
        return salesRepository.findAll();
    }

    public void addSales(Sales sales){
        salesRepository.save(sales);
    }
}
