package com.webproject.zerosheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransactionResultController {

    @Autowired
    public final TransactionResultRepository repository;

    @Autowired
    private TransactionRepository tRepo;

    @GetMapping("/result")
    public ModelAndView resultPage() {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("tNames", tRepo.findAll());
        TransactionResult result = new TransactionResult();
        repository.save(result);
        return modelAndView;
    }

}
