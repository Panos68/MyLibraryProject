package com.panos.model.services.impl;

import com.panos.model.Author;
import com.panos.model.Book;
import com.panos.model.dto.AuthorDTO;
import com.panos.model.repositories.AuthorRepository;
import com.panos.model.services.AuthorService;
import com.panos.model.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private BookService bookService;
    private ConversionService conversionService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService, ConversionService conversionService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
        this.conversionService = conversionService;
    }

    @Override
    public Set<AuthorDTO> getAllAuthors() {
        final List<Author> allAuthors = authorRepository.findAll();
        Set<AuthorDTO> authorDTOS = new HashSet<>();
        allAuthors.forEach(b -> {
            final AuthorDTO authorDTO = conversionService.convert(b, AuthorDTO.class);
            authorDTOS.add(authorDTO);
        });
        return authorDTOS;
    }

    @Override
    public void createAuthor(AuthorDTO authorDTO) {
        final Author author = conversionService.convert(authorDTO, Author.class);
        authorRepository.saveAndFlush(author);
    }

    @Override
    public void assignBooksToAuthor(Long authorId, Set<Long> bookIds) throws Exception {
        Author author = getAuthor(authorId);
        for (Long id : bookIds){
            final Book book = bookService.getBook(id);
            author.addBook(book);
            authorRepository.saveAndFlush(author);
        }
    }
    private Author getAuthor(Long authorId) throws Exception {
        final Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return author.get();
        } else {
            throw new Exception("Author doesn't exist");
        }
    }
}