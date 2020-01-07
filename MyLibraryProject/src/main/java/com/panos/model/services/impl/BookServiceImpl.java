package com.panos.model.services.impl;

import com.panos.model.Book;
import com.panos.model.dto.BookDTO;
import com.panos.model.repositories.BookRepository;
import com.panos.model.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    ConversionService conversionService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ConversionService conversionService) {
        this.bookRepository = bookRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Set<BookDTO> getAllBooks() {
        final List<Book> allBooks = bookRepository.findAll();
        Set<BookDTO> bookDTOS= new HashSet<>();
        allBooks.forEach(b -> {
            final BookDTO bookDTO = conversionService.convert(b, BookDTO.class);
            bookDTOS.add(bookDTO);
        });
        return bookDTOS;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public Book getBook(Long id) throws Exception {
        final Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return book.get();
        }
        else {
            throw new Exception("Book doesn't exist");
        }
    }
}
