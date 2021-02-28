package com.example.demotask2.rest;

import com.example.demotask2.dto.PersonDto;
import com.example.demotask2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/person")
public class PersonRestController {

    @Autowired
    PersonService service;

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PersonDto getPersonById(@PathVariable Long id) {
        return new PersonDto(service.getPerson(id));
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PersonDto> getAll() {
        return service.getAll().stream().map(PersonDto::new).collect(Collectors.toList());
    }
}
