package com.webproject.zerosheet.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService productsService;

    @RequestMapping("/products")
    public String viewProducts(Model model){
        List<Item> listItem = productsService.getAll();
        model.addAttribute("listItem", listItem);

        return "products";
    }

    @RequestMapping(value = "/addProd")
    public String showAddProdForm(Model model){
        model.addAttribute("formData", new ItemDto());

        return "addProd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("formData") ItemDto productDto){

        productsService.addProduct(productDto);

        return "redirect:/products";
    }

    @RequestMapping("/editProd/{prodID}")
    public ModelAndView showEditProduct(@PathVariable(name = "prodID") Long prodID){
        ModelAndView modelAndView = new ModelAndView();

        Item products = productsService.getProd(prodID);

        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping("/deleteProd/{prodID}")
    public String deleteProduct(@PathVariable(name = "prodID") Long prodID) {

        productsService.remProduct(prodID);

        return "redirect:/products";
    }


}
