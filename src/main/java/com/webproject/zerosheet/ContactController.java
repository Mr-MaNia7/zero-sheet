package com.webproject.zerosheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ContactController {
    @Autowired
    private final ContactRepository cRepo;

    @GetMapping("/contact")
    public ModelAndView contactPage(){
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("cform",new ContactForm());

        modelAndView.addObject("names",cRepo.findAll());
        return modelAndView;
    }
    
    @PostMapping("/contact")
    public ModelAndView result (@ModelAttribute("cform") ContactForm cform){
        ModelAndView modelAndView = new ModelAndView("contactresult");
        
        Contact text = new Contact();
        text.setText(cform.getText());
        cRepo.save(text);
        
        
        Contact cfname = new Contact();
        text.setText(cform.getText());
        cRepo.save(cfname);

        
        Contact eAddress = new Contact();
        text.setText(cform.getText());
        cRepo.save(eAddress);

        return modelAndView;
    }
}
