package com.panos.model.converters;

import com.panos.model.Author;
import com.panos.model.dto.AuthorDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthor implements Converter<AuthorDTO, Author> {

    @Override
    public Author convert(AuthorDTO authorDTO) {
        Author author = new Author(authorDTO.getName(), authorDTO.getBooks());
        author.setId(authorDTO.getId());
        return author;
    }
}
