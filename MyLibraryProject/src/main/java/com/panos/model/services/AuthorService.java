package com.panos.model.services;

import com.panos.model.dto.AuthorDTO;

import java.util.Set;

public interface AuthorService {
    Set<AuthorDTO> getAllAuthors();

    void createAuthor(AuthorDTO author);

    void assignBooksToAuthor(Long authorId, Set<Long> bookIds) throws Exception;
}
