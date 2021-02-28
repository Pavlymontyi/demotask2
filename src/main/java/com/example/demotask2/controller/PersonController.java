package com.example.demotask2.controller;

import com.example.demotask2.service.ExpenseService;
import com.example.demotask2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService service;

    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public String getAllPersonsScreen(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("persons", service.getAll());
        return Page.PERSONS.getUrl();
    }

    @PostMapping
    public String addNewPerson(@RequestParam String name, @ModelAttribute("model") ModelMap model) {
        service.createNewPerson(name);
        model.addAttribute("persons", service.getAll());
        return Page.PERSONS.getUrl();
    }

    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable Long id, @ModelAttribute("model") ModelMap model) {
        service.deletePerson(id);
        model.addAttribute("persons", service.getAll());
        return Page.PERSONS.getUrl();
    }

    @GetMapping("/{id}")
    public String showPersonExpenses(@PathVariable Long id, @ModelAttribute("model") ModelMap model) {
        model.addAttribute("expenses", expenseService.getLastExpensesFromPersons(id));
        return Page.EXPENSES.getUrl();
    }
}
