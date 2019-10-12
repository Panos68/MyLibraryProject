package com.panos.model.converters;

import com.panos.model.Book;
import com.panos.model.dto.BookDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookToBookDTOShould {

    private BookToBookDTO bookToBookDTO = new BookToBookDTO();

    @Test
    void keepNameAfterConversion() {
        Book book = new Book();
        String name = "Book";
        book.setName(name);
        BookDTO bookDTO = this.bookToBookDTO.convert(book);

        assertEquals(bookDTO.getName(), name);
    }

    @Test
    void keepIdAfterConversion() {
        Book book = new Book();
        Long id = 1L;
        book.setId(id);
        BookDTO bookDTO = this.bookToBookDTO.convert(book);

        assertEquals(bookDTO.getId(), id);
    }

}
