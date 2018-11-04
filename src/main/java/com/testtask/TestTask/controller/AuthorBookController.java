package com.testtask.TestTask.controller;


import com.testtask.TestTask.models.AuthorBook;
import com.testtask.TestTask.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authorbook")
public class AuthorBookController {
    private final AuthorBookService authorBookService;

    @Autowired
    public AuthorBookController(AuthorBookService authorBookService) {
        this.authorBookService = authorBookService;
    }


    @GetMapping(value = "/all")
    public List<AuthorBook> authorBookList() {
        return authorBookService.getAuthorBookList();
    }


    @GetMapping("/{id}")
    public String authorBookData(@PathVariable("id") int id) {
        return authorBookService.getAuthorBookById(id).toString();
    }

    @PostMapping(value = "/add")
    public void addAuthorBook(@RequestBody AuthorBook authorBook) {
        authorBookService.addAuthorBook(authorBook);
    }

    @DeleteMapping("/{id}")
    public void removeAuthorBook(@PathVariable("id") int id) {
        authorBookService.removeAuthorBook(id);
    }

    @PutMapping("/{id}")
    public void updateAuthorBook(@PathVariable("id") int id, @RequestBody AuthorBook authorBook) {
        authorBookService.updateAuthorBook(id, authorBook);
    }
}
