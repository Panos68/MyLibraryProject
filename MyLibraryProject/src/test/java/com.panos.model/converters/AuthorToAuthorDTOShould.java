package com.panos.model.converters;

import com.panos.model.Author;
import com.panos.model.Book;
import com.panos.model.dto.AuthorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorToAuthorDTOShould {

    private AuthorToAuthorDTO authorToAuthorDTO = new AuthorToAuthorDTO();
    private String name = "Author";
    private List<Book> bookList = Arrays.asList(new Book("Book1"),new Book("Book2"));
    private Author author;

    @BeforeEach
    void setUp() {
       author = new Author(name, bookList);
    }

    @Test
    void keepNameAfterConversion(){
        AuthorDTO authorDTO = this.authorToAuthorDTO.convert(author);
        assertEquals(authorDTO.getName(),name);
    }

    @Test
    void keepIdAfterConversion(){
        Long id=1L;
        author.setId(id);
        AuthorDTO authorDTO = this.authorToAuthorDTO.convert(author);
        assertEquals(authorDTO.getId(),id);
    }

    @Test
    void keepBooksAfterConversion(){
        AuthorDTO authorDTO = this.authorToAuthorDTO.convert(author);
        assertEquals(authorDTO.getBooks(), bookList);
    }
}
