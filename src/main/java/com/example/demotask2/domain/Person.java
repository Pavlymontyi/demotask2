package com.example.demotask2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Person() {
        //Default construct according to JPA requirements
    }

    public Person(String name) {
        this.name = name;
    }
}
