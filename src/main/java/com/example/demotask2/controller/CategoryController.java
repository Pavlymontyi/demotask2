package com.example.demotask2.controller;

import com.example.demotask2.service.CategoryService;
import com.example.demotask2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping
    public String getAllPersonsScreen(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("categories", service.getAll());
        return Page.CATEGORIES.getUrl();
    }

    @PostMapping
    public String addNewCategory(@RequestParam String name, @ModelAttribute("model") ModelMap model) {
        service.createNewCategory(name);
        model.addAttribute("categories", service.getAll());
        return Page.CATEGORIES.getUrl();
    }

    @GetMapping("/{id}")
    public String deleteCategory(@PathVariable Long id, @ModelAttribute("model") ModelMap model) {
        service.deleteCategory(id);
        model.addAttribute("categories", service.getAll());
        return Page.CATEGORIES.getUrl();
    }
}
