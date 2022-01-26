package com.webproject.zerosheet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class TransactionController {
    @Autowired
    private TransactionRepository tRepo;
    
    @Autowired
    private final ItemRepository itemRepo;
    
    @GetMapping("/transaction")
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView("transaction");
        modelAndView.addObject("tform",new TransactionForm());
        modelAndView.addObject("itemNames",itemRepo.findAll());
        modelAndView.addObject("names",tRepo.findAll());
        return modelAndView;
    }

    @PostMapping("/transaction")
    public ModelAndView result (@ModelAttribute("tform") TransactionForm tform){
        ModelAndView modelAndView = new ModelAndView("result");
        
        Transaction transaction = new Transaction();
        transaction.setTransactionName(tform.getTransactionName());
        tRepo.save(transaction);

        return modelAndView;
    }


}