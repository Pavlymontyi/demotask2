package com.example.demotask2.rest;

import com.example.demotask2.dto.PersonDto;
import com.example.demotask2.dto.PersonsDto;
import com.example.demotask2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/xml/person")
public class PersonXmlRestController {

    @Autowired
    PersonService service;

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE, produces= MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public PersonDto getPersonByIdXml(@PathVariable Long id) {
        return new PersonDto(service.getPerson(id));
    }

    @GetMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces= MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public PersonsDto getAllXml() {
        List<PersonDto> persons = service.getAll().stream().map(PersonDto::new).collect(Collectors.toList());
        return new PersonsDto(persons);
    }
}
