package com.webproject.zerosheet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String showRegistration(UserFormData userFormData){
        return "registration";
    }

    @PostMapping("registration")
    public String newUser(@Valid UserFormData userFormData, BindingResult result){
        if (result.hasErrors()){
            return "registration";
        }

        // Convert data
        var addedUser = userFormData.convertData();

        // Save data
        userService.newUser(addedUser);

        return "redirect:/login";

    }
}
