package com.panos.model.controllers;

import com.panos.model.dto.PublisherDTO;
import com.panos.model.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public Set<PublisherDTO> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @PostMapping
    public void createPublisher(@RequestBody PublisherDTO publisherDTO){
        publisherService.createPublisher(publisherDTO);
    }
}
