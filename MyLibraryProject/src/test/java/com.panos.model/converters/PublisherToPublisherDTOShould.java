package com.panos.model.converters;

import com.panos.model.Book;
import com.panos.model.Publisher;
import com.panos.model.dto.PublisherDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublisherToPublisherDTOShould {

    private PublisherToPublisherDTO publisherToPublisherDTO = new PublisherToPublisherDTO();

    private Publisher publisher;


    @BeforeEach
    void setUp() {
        publisher = new Publisher("", Collections.emptyList());
    }

    @Test
    void keepNameAfterConversion() {
        String name = "Publisher";
        publisher.setName(name);
        PublisherDTO publisherDTO = this.publisherToPublisherDTO.convert(publisher);

        assertEquals(publisherDTO.getName(), name);
    }

    @Test
    void keepIdAfterConversion() {
        Long id = 1L;
        publisher.setId(id);
        PublisherDTO publisherDTO = this.publisherToPublisherDTO.convert(publisher);

        assertEquals(publisherDTO.getId(), id);
    }

    @Test
    void keepBooksAfterConversion() {
        List<Book> bookList = new ArrayList();
        Book book = new Book("book1");
        bookList.add(book);
        publisher.setBookList(bookList);
        PublisherDTO publisherDTO = this.publisherToPublisherDTO.convert(publisher);

        assertEquals(publisherDTO.getBookList(), bookList);
    }

}