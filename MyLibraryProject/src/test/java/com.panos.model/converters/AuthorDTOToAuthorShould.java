package com.panos.model.converters;

import com.panos.model.Author;
import com.panos.model.Book;
import com.panos.model.dto.AuthorDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorDTOToAuthorShould {

    private AuthorDTOToAuthor authorDTOToAuthor = new AuthorDTOToAuthor();

    @Test
    void keepNameAfterConversion(){
        AuthorDTO authorDTO = new AuthorDTO();
        String name = "Author";
        authorDTO.setName(name);
        Author author = this.authorDTOToAuthor.convert(authorDTO);

        assertEquals(author.getName(),name);
    }

    @Test
    void keepIdAfterConversion(){
        AuthorDTO authorDTO = new AuthorDTO();
        Long id = 1L;
        authorDTO.setId(id);
        Author author = authorDTOToAuthor.convert(authorDTO);

        assertEquals(author.getId(),id);
    }

    @Test
    void keepBooksAfterConversion(){
        AuthorDTO authorDTO = new AuthorDTO();
        List<Book> bookList = Arrays.asList(new Book("Book1"),new Book("Book2"));
        authorDTO.setBooks(bookList);
        Author author = this.authorDTOToAuthor.convert(authorDTO);

        assertEquals(author.getBooks(),bookList);
    }
}
