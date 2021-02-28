package com.example.demotask2.service;

import com.example.demotask2.domain.Category;
import com.example.demotask2.domain.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Category> getAll() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }

    public void createNewCategory(String name) {
        int size = entityManager
                .createQuery("select c from Category c where c.name=:name")
                .setParameter("name", name)
                .getResultList()
                .size();
        if (size != 0) {
            throw new RuntimeException("Category with this name was created before");
        }
        Category c = new Category(name);
        entityManager.persist(c);
    }

    public void deleteCategory(Long id) {
        entityManager
                .createQuery("delete from Category c where c.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
