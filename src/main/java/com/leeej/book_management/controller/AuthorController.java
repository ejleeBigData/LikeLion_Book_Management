package com.leeej.book_management.controller;

import com.leeej.book_management.dto.AuthorDto;
import com.leeej.book_management.model.Author;
import com.leeej.book_management.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    /*
    public List<Author> list() {
        return authorService.getAll();
    }
    */
    public ResponseEntity<List<Author>> list() {
        List<Author> authors = authorService.getAll();

        return ResponseEntity.ok(authors);
    }


    /*
    public Author get(@PathVariable Integer id) {
        return authorService.getById(id);
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Author> get(@PathVariable Integer id) {
        Author author = authorService.getById(id);

        return ResponseEntity.ok(author);
    }

    /*
   public Author create(@Valid @RequestBody AuthorDto authorDto) {
       Author author = new Author();
       author.setName(authorDto.getName());

       return authorService.create(author);
   }*/
    @PostMapping
    public ResponseEntity<Author> create(@Valid @RequestBody AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());

        Author saved = authorService.create(author);

        return ResponseEntity.created(URI.create("/api/authors/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(
            @PathVariable Integer id,
            @Valid @RequestBody AuthorDto authorDto
    ) {
        Author author = new Author();
        author.setName(authorDto.getName());

        Author updated = authorService.update(id, author);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        authorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
