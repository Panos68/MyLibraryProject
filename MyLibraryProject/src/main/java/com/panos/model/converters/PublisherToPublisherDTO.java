package com.panos.model.converters;

import com.panos.model.Publisher;
import com.panos.model.dto.PublisherDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublisherToPublisherDTO implements Converter<Publisher, PublisherDTO> {
    @Override
    public PublisherDTO convert(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setBookList(publisher.getBookList());
        publisherDTO.setName(publisher.getName());
        return publisherDTO;
    }
}
