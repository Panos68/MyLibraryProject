package com.panos.model.services;

import com.panos.model.Author;
import com.panos.model.Book;
import com.panos.model.dto.AuthorDTO;
import com.panos.model.repositories.AuthorRepository;
import com.panos.model.services.impl.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceShould {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private ConversionService conversionService;

    @Mock
    private BookService bookService;

    private AuthorService authorService;

    private Author author1;

    private Author author2;

    private Long authorId = 1L;

    private AuthorDTO authorDTO1;

    private Book book1;

    private Long bookId = 2L;

    private Set<Long> bookListIds = new HashSet<>();

    @Before
    public void setUp() {
        authorService = new AuthorServiceImpl(authorRepository, bookService, conversionService);

        author1 = new Author("Author1", Collections.emptyList());
        author1.setId(authorId);
        author2 = new Author("Author2", Collections.emptyList());
        when(authorRepository.findAll()).thenReturn(authorsList);

        authorDTO1 = new AuthorDTO();
        when(conversionService.convert(authorDTO1, Author.class)).thenReturn(author1);
        when(conversionService.convert(author1, AuthorDTO.class)).thenReturn(authorDTO1);

        AuthorDTO authorDTO2 = new AuthorDTO();
        when(conversionService.convert(author2, AuthorDTO.class)).thenReturn(authorDTO2);

        book1 = new Book("Book1");
        book1.setId(bookId);
        bookListIds.add(bookId);
    }

    private List<Author> authorsList = new ArrayList<>();

    @Test
    public void updateAuthorWhenAssigningExistingBookToExistingAuthor() throws Exception {
        Mockito.when(authorRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(author1));
        Mockito.when(bookService.getBook(bookId)).thenReturn(book1);
        authorService.assignBooksToAuthor(authorId, bookListIds);

        verify(authorRepository, times(1)).saveAndFlush(author1);
    }

    @Test
    public void notUpdateAuthorWhenAssigningNonExistingBookToExistingAuthor() throws Exception {
        Mockito.when(authorRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(author1));
        authorService.assignBooksToAuthor(authorId, bookListIds);

        verify(authorRepository, times(0)).saveAndFlush(author1);
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenAssigningToNonExistingAuthor() throws Exception {
        authorService.assignBooksToAuthor(authorId, bookListIds);
    }

    @Test
    public void saveToRepositoryWhenCreatingAuthor() throws Exception {
        authorService.createAuthor(authorDTO1);

        verify(authorRepository, times(1)).saveAndFlush(author1);
    }

    @Test
    public void returnListOfAllExistingAuthors() throws Exception {
        authorsList.add(author1);
        authorsList.add(author2);
        Set<AuthorDTO> authorsDTO = authorService.getAllAuthors();

        Assert.assertThat(authorsDTO.size(), is(2));
    }

    @Test
    public void returnEmptyListIfThereAreNoAuthors() throws Exception {
        when(authorRepository.findAll()).thenReturn(authorsList);
        Set<AuthorDTO> authorsDTO = authorService.getAllAuthors();

        Assert.assertThat(authorsDTO.isEmpty(), is(true));
    }
}
