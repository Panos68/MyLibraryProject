package com.panos.model.converters;

import com.panos.model.Book;
import com.panos.model.Publisher;
import com.panos.model.dto.PublisherDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PublisherDTOToPublisherShould {

    private PublisherDTOToPublisher publisherDTOToPublisher = new PublisherDTOToPublisher();

    private PublisherDTO publisherDTO;


    @BeforeEach
    void setUp() {
        publisherDTO = new PublisherDTO();
    }

    @Test
    void keepNameAfterConversion() {
        String name = "Publisher";
        publisherDTO.setName(name);
        Publisher publisher = this.publisherDTOToPublisher.convert(publisherDTO);

        assertEquals(publisher.getName(), name);
    }

    @Test
    void keepBooksAfterConversion() {
        List<Book> bookList = new ArrayList();
        Book book = new Book("book1");
        bookList.add(book);
        publisherDTO.setBookList(bookList);
        Publisher publisher = this.publisherDTOToPublisher.convert(publisherDTO);

        assertEquals(publisher.getBookList(), bookList);
    }

}