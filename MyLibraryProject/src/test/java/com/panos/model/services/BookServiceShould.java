package com.panos.model.services;

import com.panos.model.Book;
import com.panos.model.dto.BookDTO;
import com.panos.model.repositories.BookRepository;
import com.panos.model.services.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceShould {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ConversionService conversionService;

    private BookService bookService;

    private Book book1;

    private Book book2;

    private Long id = 1L;

    private List<Book> bookList = new ArrayList<>();

    @Before
    public void setUp() {
        bookService = new BookServiceImpl(bookRepository, conversionService);

        book1 = new Book("Book1");
        book1.setId(id);
        book2 = new Book("Book2");
        when(bookRepository.findAll()).thenReturn(bookList);

        BookDTO bookDTO1 = new BookDTO();
        BookDTO bookDTO2 = new BookDTO();
        when(conversionService.convert(book1, BookDTO.class)).thenReturn(bookDTO1);
        when(conversionService.convert(book2, BookDTO.class)).thenReturn(bookDTO2);
    }

    @Test
    public void returnBookIfIdExists() throws Exception {
        Mockito.when(bookRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(book1));
        Book responseBook = bookService.getBook(id);

        Assert.assertEquals(responseBook, book1);
    }

    @Test(expected = Exception.class)
    public void throwExceptionIfBookDoesNotExist() throws Exception {
        bookService.getBook(1L);
    }

    @Test
    public void callRepositoryWhenAddingBook() throws Exception {
        bookService.addBook(book1);

        verify(bookRepository, times(1)).saveAndFlush(book1);
    }

    @Test
    public void returnListOfAllExistingBooks() throws Exception {
        bookList.add(book1);
        bookList.add(book2);
        Set<BookDTO> allBooks = bookService.getAllBooks();

        Assert.assertThat(allBooks.size(),is(2));
    }

    @Test
    public void returnEmptyListIfThereAreNoBooks() throws Exception {
        when(bookRepository.findAll()).thenReturn(bookList);
        Set<BookDTO> allBooks = bookService.getAllBooks();

        Assert.assertThat(allBooks.isEmpty(),is(true));
    }
}
