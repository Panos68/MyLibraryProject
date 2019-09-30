package com.panos.model.converters;

import com.panos.model.Book;
import com.panos.model.dto.BookDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDTO implements Converter<Book, BookDTO> {
    @Override
    public BookDTO convert(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        return bookDTO;
    }
}
