package com.example.demotask2.rest;

import com.example.demotask2.domain.Expense;
import com.example.demotask2.dto.ExpenseDto;
import com.example.demotask2.dto.PersonDto;
import com.example.demotask2.dto.PersonsDto;
import com.example.demotask2.service.CategoryService;
import com.example.demotask2.service.ExpenseService;
import com.example.demotask2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.xslt.XsltView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "rest/xml", produces= MediaType.APPLICATION_XML_VALUE)
public class XmlRestController {

    PersonService personService;
    ExpenseService expenseService;
    CategoryService categoryService;

    @Autowired
    public XmlRestController(PersonService personService, ExpenseService expenseService, CategoryService categoryService) {
        this.personService = personService;
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/person/{id}")
    //@ResponseBody
    public ModelAndView getPersonByIdXml(@PathVariable Long id) {
        ModelAndView mod = new ModelAndView("test");
        mod.getModel().put("persons", new PersonDto(personService.getPerson(id)));
        mod.setViewName("test");

        return mod;
    }

    @GetMapping(value = "/person")
    @ResponseBody
    public PersonsDto getAllXml() {
        List<PersonDto> persons = personService.getAll().stream().map(PersonDto::new).collect(Collectors.toList());
        return new PersonsDto(persons);
    }

    @GetMapping(path = "/expense/{personId}")
    public List<ExpenseDto> getExpenseByPerson(@PathVariable Long personId) {
        return expenseService.getLastExpensesFromPersons(personId).stream().map(ExpenseDto::new).collect(Collectors.toList());
    }
}
