package com.example.demotask2.dto;

import com.example.demotask2.domain.Expense;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "expense")
@Getter
public class ExpenseDto {
    @XmlElement
    private Long id;
    @XmlElement
    private String description;
    @XmlElement
    private double amount;
    @XmlElement
    private Date expenseDate;
    @XmlElement
    private String category;

    public ExpenseDto() {
    }

    public ExpenseDto(Expense expense) {
        this.id = expense.getId();
        this.description = expense.getDescription();
        this.amount = expense.getAmount();
        this.expenseDate = expense.getExpenseDate();
        this.category = expense.getCategory().getName();
    }
}
