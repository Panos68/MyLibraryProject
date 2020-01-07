package com.panos.model.services;

import com.panos.model.Publisher;
import com.panos.model.dto.PublisherDTO;
import com.panos.model.repositories.PublisherRepository;
import com.panos.model.services.impl.PublisherServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PublisherServiceShould {

    private List<Publisher> publisherList = new ArrayList<>();

    @Mock
    private PublisherRepository publisherRepository;

    private PublisherService publisherService;

    @Mock
    private ConversionService conversionService;

    private Publisher publisher1;

    private Publisher publisher2;

    private PublisherDTO publisherDTO1;

    private PublisherDTO publisherDTO2;

    @Before
    public void setUp() throws Exception {
        publisher1 = new Publisher("Publisher1", Collections.emptyList());

        publisher2 = new Publisher("Publisher2", Collections.emptyList());

        publisherService = new PublisherServiceImpl(publisherRepository, conversionService);

        Mockito.when(publisherRepository.findAll()).thenReturn(publisherList);
        publisherDTO1 = new PublisherDTO();
        Mockito.when(conversionService.convert(publisher1, PublisherDTO.class)).thenReturn(publisherDTO1);
        publisherDTO2 = new PublisherDTO();
        Mockito.when(conversionService.convert(publisher1, PublisherDTO.class)).thenReturn(publisherDTO2);

        Mockito.when(conversionService.convert(publisherDTO1, Publisher.class)).thenReturn(publisher1);
    }

    @Test
    public void returnListOfAllExistingPublishers() throws Exception {
        publisherList.add(publisher1);
        publisherList.add(publisher2);
        Set<PublisherDTO> publisherDTOS = publisherService.getAllPublishers();

        Assert.assertThat(publisherDTOS.size(), is(2));
    }

    @Test
    public void returnEmptyListIfThereAreNoPublishers() throws Exception {
        Set<PublisherDTO> publisherDTOS = publisherService.getAllPublishers();

        Assert.assertThat(publisherDTOS.isEmpty(), is(true));
    }

    @Test
    public void saveToRepositoryWhenCreatingAuthor() throws Exception {
        publisherService.createPublisher(publisherDTO1);

        verify(publisherRepository, times(1)).saveAndFlush(publisher1);
    }
}