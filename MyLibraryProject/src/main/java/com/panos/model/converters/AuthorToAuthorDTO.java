package com.panos.model.converters;

import com.panos.model.Author;
import com.panos.model.dto.AuthorDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorDTO implements Converter<Author, AuthorDTO> {

    @Override
    public AuthorDTO convert(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBooks(author.getBooks());
        return authorDTO;
    }
}
