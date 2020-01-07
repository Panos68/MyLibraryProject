package com.panos.model.converters;

import com.panos.model.Publisher;
import com.panos.model.dto.PublisherDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublisherDTOToPublisher implements Converter<PublisherDTO, Publisher> {
    @Override
    public Publisher convert(PublisherDTO publisherDTO) {
        return new Publisher(publisherDTO.getName(),publisherDTO.getBookList());
    }
}
