package com.example.demotask2.service;

import com.example.demotask2.domain.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    public void createNewPerson(String name) {
        Person p = new Person(name);
        entityManager.persist(p);
    }

    public void deletePerson(Long id) {
        entityManager
                .createQuery("delete from Person p where p.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Person getPerson(Long id) {
        return entityManager.find(Person.class, id);
    }
}
