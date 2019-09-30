package com.panos.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Column
    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
