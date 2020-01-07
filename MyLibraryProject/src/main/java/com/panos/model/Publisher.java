package com.panos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Column
    String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="publishers.id")
    List<Book> bookList = new ArrayList<>();

    protected Publisher() {
    }

    public Publisher(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
