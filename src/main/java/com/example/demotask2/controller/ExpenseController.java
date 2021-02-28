package com.example.demotask2.controller;

import com.example.demotask2.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @GetMapping
    public String getAllByLastMonth(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("expenses", service.getLastExpenses());
        return Page.EXPENSES.getUrl();
    }

    @PostMapping
    public String createNewExpense(@RequestParam String description,
                                   @RequestParam Double amount,
                                   @RequestParam Long person_id,
                                   @RequestParam Long category_id,
                                   @ModelAttribute("model") ModelMap model) {
        service.createNewExpense(description, amount, person_id, category_id);

        model.addAttribute("expenses", service.getLastExpensesFromPersons(person_id));
        return Page.EXPENSES.getUrl();
    }
}
