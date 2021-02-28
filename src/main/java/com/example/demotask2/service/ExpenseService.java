package com.example.demotask2.service;

import com.example.demotask2.domain.Category;
import com.example.demotask2.domain.Expense;
import com.example.demotask2.domain.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ExpenseService {
    @PersistenceContext
    EntityManager entityManager;

    public List<Category> getLastExpensesFromPersons(Long personId) {
        return entityManager
                .createQuery("select e from Expense e where e.person.id=:id")
                .setParameter("id", personId)
                .getResultList();
    }

    public List<Category> getLastExpenses() {
        return entityManager
                .createQuery("select e from Expense e")
                .getResultList();
    }

    public Expense createNewExpense(String description, Double amount, Long personId, Long categoryId) {
        Person person = entityManager.find(Person.class, personId);
        Category category = entityManager.find(Category.class, categoryId);
        Expense exp = new Expense(description, amount, new Date(), person, category);
        entityManager.persist(exp);
        return exp;
    }
}
