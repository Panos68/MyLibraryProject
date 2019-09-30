package com.panos.model.dto;

import com.panos.model.Book;

import java.util.List;

public class AuthorDTO {
    private String name;
    private Long id;
    private List<Book> books;

    public AuthorDTO() {
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
}
