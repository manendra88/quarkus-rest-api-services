package com.quarkus.rest.application.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAll", query = "SELECT p FROM Person p")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String surname;



}
