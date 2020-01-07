package com.panos.model.services.impl;

import com.panos.model.Publisher;
import com.panos.model.dto.PublisherDTO;
import com.panos.model.repositories.PublisherRepository;
import com.panos.model.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PublisherServiceImpl implements PublisherService {

    PublisherRepository publisherRepository;

    ConversionService conversionService;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository, ConversionService conversionService) {
        this.publisherRepository = publisherRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Set<PublisherDTO> getAllPublishers() {
        List<Publisher> allPublishers = publisherRepository.findAll();
        Set<PublisherDTO> publisherDTOS = new HashSet<>();
        allPublishers.forEach(publisher -> {
            PublisherDTO publisherDTO = conversionService.convert(publisher, PublisherDTO.class);
            publisherDTOS.add(publisherDTO);
        });
        return publisherDTOS;
    }

    @Override
    public void createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = conversionService.convert(publisherDTO, Publisher.class);
        publisherRepository.saveAndFlush(publisher);
    }
}
