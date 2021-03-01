package com.example.demotask2.rest;

import com.example.demotask2.dto.ExpenseDto;
import com.example.demotask2.dto.PersonDto;
import com.example.demotask2.service.CategoryService;
import com.example.demotask2.service.ExpenseService;
import com.example.demotask2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest")
public class JsonRestController {

    PersonService personService;
    ExpenseService expenseService;
    CategoryService categoryService;

    @Autowired
    public JsonRestController(PersonService service, ExpenseService expenseService, CategoryService categoryService) {
        this.personService = service;
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/person/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PersonDto getPersonById(@PathVariable Long id) {
        return new PersonDto(personService.getPerson(id));
    }

    @GetMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PersonDto> getAll() {
        return personService.getAll().stream().map(PersonDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/expense/{personId}")
    public List<ExpenseDto> getExpenseByPerson(@PathVariable Long personId) {
        return expenseService.getLastExpensesFromPersons(personId).stream().map(ExpenseDto::new).collect(Collectors.toList());
    }
}
