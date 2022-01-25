package com.webproject.zerosheet.transaction.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService){
        this.salesService = salesService;
    }

    @GetMapping
    public List<Sales> getSales(){
        return salesService.getSales();
    }

    @PostMapping
    public void newSales(@RequestBody Sales sales){
        salesService.addSales(sales);
    }
}
