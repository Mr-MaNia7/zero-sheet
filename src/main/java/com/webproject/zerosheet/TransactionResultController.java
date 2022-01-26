package com.webproject.zerosheet;

import javax.validation.Valid;
//import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


@Controller
@Slf4j
@RequiredArgsConstructor
@SessionAttributes("transactionResult")
public class TransactionResultController {
    
    public final TransactionResultRepository repository;

    @GetMapping("/transactions/current")
    public String transactionResult(Model model) {
        model.addAttribute("transactionResult", new TransactionResult());
        return "result";
    }
   
    @PostMapping("/transactions")
    public String processTransaction(@Valid TransactionResult transactionResult, 
    Errors error, SessionStatus status ) {
        if (error.hasErrors()) {
            return "result";
        }

        this.repository.save(transactionResult);
        log.info("Transaction Processed: " + transactionResult);
        status.setComplete();
        
        return "redirect:/transactions/currrent";
    }
    
}
