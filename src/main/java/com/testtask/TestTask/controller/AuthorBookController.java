package com.testtask.TestTask.controller;


import com.testtask.TestTask.models.AuthorBook;
import com.testtask.TestTask.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/authorbook")
public class AuthorBookController {
    private final AuthorBookService authorBookService;

    @Autowired
    public AuthorBookController(AuthorBookService authorBookService) {
        this.authorBookService = authorBookService;
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public List<AuthorBook> authorBookList(@ModelAttribute("authorBook") AuthorBook authorBook) {
        return authorBookService.getAuthorBookList();
    }


    @RequestMapping("/{id}")
    @ResponseBody
    public String authorBookData(@PathVariable("id") int id) {
        return authorBookService.getAuthorBookById(id).toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addAuthorBook(@ModelAttribute("authorBook") AuthorBook authorBook) {
        authorBookService.addAuthorBook(authorBook);
    }

    @RequestMapping("/remove/{id}")
    public void removeAuthorBook(@PathVariable("id") int id) {
        authorBookService.removeAuthorBook(id);
    }

    @RequestMapping("/update/{id}")
    public void updateAuthorBook(@PathVariable("id") int id, int authorid) {
        authorBookService.updateAuthorBook(id, authorid);
    }
}
