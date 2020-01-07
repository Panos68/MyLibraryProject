package com.panos.model.services;

import com.panos.model.dto.PublisherDTO;

import java.util.Set;

public interface PublisherService {
    Set<PublisherDTO> getAllPublishers();

    void createPublisher(PublisherDTO publisherDTO);
}
