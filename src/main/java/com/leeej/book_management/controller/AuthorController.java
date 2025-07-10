package com.leeej.book_management.controller;

import com.leeej.book_management.dto.AuthorDto;
import com.leeej.book_management.model.Author;
import com.leeej.book_management.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public Author create(@Valid @RequestBody AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());

        return authorService.create(author);

    }

}
