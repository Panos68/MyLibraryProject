package com.panos.model.controllers;

import com.panos.model.Book;
import com.panos.model.dto.BookDTO;
import com.panos.model.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Set<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
}
