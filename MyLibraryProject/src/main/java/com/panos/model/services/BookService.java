package com.panos.model.services;

import com.panos.model.Book;
import com.panos.model.dto.BookDTO;

import java.util.Set;

public interface BookService {
    Set<BookDTO> getAllBooks();

    void addBook(Book book);

    Book getBook(Long id) throws Exception;
}
