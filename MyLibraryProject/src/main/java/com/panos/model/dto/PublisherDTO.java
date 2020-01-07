package com.panos.model.dto;

import com.panos.model.Book;

import java.util.ArrayList;
import java.util.List;

public class PublisherDTO {
    private String name;
    private Long id;
    private List<Book> bookList;

    public PublisherDTO() {
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
