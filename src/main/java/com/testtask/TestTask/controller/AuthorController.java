package com.testtask.TestTask.controller;

import com.testtask.TestTask.models.Author;
import com.testtask.TestTask.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) throws ParseException {
        this.authorService = authorService;
    }


    @GetMapping(value = "/all")
    public List<Author> authorList() {
        return authorService.getAuthorList();
    }

    @GetMapping("/{id}")
    public String authorId(@PathVariable("id") int id) {
        return authorService.getAuthorById(id).toString();
    }

    @PostMapping(value = "/add")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void removeAuthor(@PathVariable("id") String id) {
        authorService.removeAuthor(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable("id") int id) {
        authorService.updateAuthor(id);
    }

    @GetMapping(value = "/born")
    public List<Author> sortByBorn(@ModelAttribute("author") Author author) {
        return authorService.sortByBorn();
    }

    @GetMapping("/mostAuthor")
    public String getMostAuthor(@ModelAttribute("author") Author author) {
        return authorService.getMostAuthor().toString();
    }
}
