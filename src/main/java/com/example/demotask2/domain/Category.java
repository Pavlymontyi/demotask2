package com.example.demotask2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="categories")
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    /**
     * Default construct according to JPA requirements
     */
    public Category() {
        //Default construct according to JPA requirements
    }


    public Category(String name) {
        this.name = name;
    }
}
