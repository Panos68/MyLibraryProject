package com.panos.model.controllers;

import com.panos.model.dto.AuthorDTO;
import com.panos.model.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<Set<AuthorDTO>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping
    public void createAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.createAuthor(authorDTO);
    }

    @PostMapping
    @RequestMapping("/{id}/associate")
    public void assignBooks(@PathVariable (name="id") Long authorId,@RequestBody Set<Long> bookIds) throws Exception {
        authorService.assignBooksToAuthor(authorId,bookIds);
    }
}