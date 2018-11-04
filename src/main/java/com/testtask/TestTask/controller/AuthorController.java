package com.testtask.TestTask.controller;

import com.testtask.TestTask.models.Author;
import com.testtask.TestTask.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) throws ParseException {
        this.authorService = authorService;
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Author> authorList(@ModelAttribute("author") Author author) {
        return authorService.getAuthorList();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String authorId(@PathVariable("id") int id) {
        return authorService.getAuthorById(id).toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addAuthor(@ModelAttribute("author") Author author) {
        authorService.addAuthor(author);
    }

    @RequestMapping("/remove/{id}")
    public void removeAuthor(@PathVariable("id") String id) {
        authorService.removeAuthor(Integer.parseInt(id));
    }

    @RequestMapping("/update/{id}")
    public void updateAuthor(@PathVariable("id") int id, String name) {
        authorService.updateAuthor(id, name);
    }

    @RequestMapping(value = "/born")
    @ResponseBody
    public List<Author> sortByBorn(@ModelAttribute("author") Author author) {
        return authorService.sortByBorn();
    }

    @RequestMapping("/mostauthor")
    @ResponseBody
    public String getMostAuthor(@ModelAttribute("author") Author author) {
        return authorService.getMostAuthor().toString();
    }
}
