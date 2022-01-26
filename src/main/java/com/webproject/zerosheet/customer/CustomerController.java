package com.webproject.zerosheet.customer;

import com.webproject.zerosheet.inventory.ProductDto;
import com.webproject.zerosheet.inventory.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String viewCustomers(Model model){
        List<Customer> listCustomer = customerService.getAll();
        model.addAttribute("listCustomer", listCustomer);

        return "customers";
    }

    @RequestMapping(value = "/addCust")
    public String showAddCustomerForm(Model model){
        model.addAttribute("formData", new CustomerDto());

        return "addCust";
    }

    @RequestMapping(value = "/addC", method = RequestMethod.POST)
    public String addNewCustomer(@ModelAttribute("formData") CustomerDto customerDto){

        customerService.addCustomer(customerDto);

        return "redirect:/customers";
    }

    @RequestMapping("/deleteCust/{custID}")
    public String deleteCustomer(@PathVariable(name = "custID") int custID) {

        customerService.remCustomer(custID);

        return "redirect:/customers";
    }
}
