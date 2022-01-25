package com.webproject.zerosheet.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService serv;

    public UserController(UserService serv) {
        this.serv = serv;
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/registration")
    public String showRegister(Model model){
        model.addAttribute("formData", new UserDataTransfer());
        return "registration";
    }

    @PostMapping("/registration")
    public String regUser(@ModelAttribute("formData") UserDataTransfer userData){

        serv.registerUser(userData);

        return "redirect:/index";
    }
}
