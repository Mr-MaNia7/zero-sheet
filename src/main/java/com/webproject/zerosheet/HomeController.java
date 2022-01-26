package com.webproject.zerosheet;

import com.webproject.zerosheet.inventory.Item;
import com.webproject.zerosheet.inventory.ItemRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemRepository itemRepository;

    @GetMapping("/")
    public String homeMapping(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("item", new Item());
        return "index";
    }
}
