package com.panos.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "authors.id")
    private List<Book> books = new ArrayList<>();

    protected Author() {
    }

    public Author(String name, List<Book> books) {
        this.name = name;
        if (!CollectionUtils.isEmpty(books)) {
            this.books = books;
        }
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        books.add(book);
    }
}
