package com.example.demotask2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="expenses")
@Setter
@Getter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private double amount;
    private Date expenseDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    public Expense() {
        //Default construct according to JPA requirements
    }

    public Expense(double amount) {
        this.amount = amount;
    }

    public Expense(String description, double amount, Date expenseDate, Person person, Category category) {
        this.description = description;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.person = person;
        this.category = category;
    }
}
