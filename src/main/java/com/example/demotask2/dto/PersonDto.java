package com.example.demotask2.dto;

import com.example.demotask2.domain.Person;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "person")
@Getter
public class PersonDto {

    @XmlElement
    private Long id;
    @XmlElement
    private String name;

    private List<ExpenseDto> expenseList;

    public PersonDto() {
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.expenseList = person.getExpenses().stream().map(ExpenseDto::new).collect(Collectors.toList());
    }

    @XmlElement(name = "expense")
    @XmlElementWrapper(name="expenses")
    public List<ExpenseDto> getExpenseList() {
        return expenseList;
    }
}
