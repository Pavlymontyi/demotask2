package com.example.demotask2.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "root")
public class PersonsDto {
    @XmlElement(name = "persons")
    List<PersonDto> persons;

    public PersonsDto() {
    }

    public PersonsDto(List<PersonDto> persons) {
        this.persons = persons;
    }
}

