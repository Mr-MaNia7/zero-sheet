package com.webproject.zerosheet.inventory.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    @RequestMapping("/sales")
    public String viewProducts(Model model){
        List<Sales> listSales = salesService.getAll();
        model.addAttribute("listSales", listSales);

        return "sales";
    }

    @RequestMapping(value = "/addSales")
    public String showAddSalesForm(Model model){
        model.addAttribute("formData", new SalesDto());

        return "addSales";
    }

    @RequestMapping(value = "/addS", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("formData") SalesDto salesDto){

        salesService.addSales(salesDto);

        return "redirect:/sales";
    }

    @RequestMapping("/deleteProd/{prodID}")
    public String deleteProduct(@PathVariable(name = "prodID") int salesID) {

        salesService.remSales(salesID);

        return "redirect:/sales";
    }
}
