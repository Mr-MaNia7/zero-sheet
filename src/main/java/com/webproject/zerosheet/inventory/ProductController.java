package com.webproject.zerosheet.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/products")
    public String viewProducts(Model model){
        List<Products> listProducts = productsService.getAll();
        model.addAttribute("listProducts", listProducts);

        return "products";
    }

    @RequestMapping(value = "/addProd")
    public String showAddProdForm(Model model){
        model.addAttribute("formData", new ProductDto());

        return "addProd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("formData") ProductDto productDto){

        productsService.addProduct(productDto);

        return "redirect:/products";
    }

    @RequestMapping("/editProd/{prodID}")
    public ModelAndView showEditProduct(@PathVariable(name = "prodID") int prodID){
        ModelAndView modelAndView = new ModelAndView();

        Products products = productsService.getProd(prodID);

        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping("/deleteProd/{prodID}")
    public String deleteProduct(@PathVariable(name = "prodID") int prodID) {

        productsService.remProduct(prodID);

        return "redirect:/products";
    }


}
