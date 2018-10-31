package com.testtask.TestTask.controller;


import com.testtask.TestTask.models.AuthorBook;
import com.testtask.TestTask.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorBookController {
    private final AuthorBookService authorBookService;

    @Autowired
    public AuthorBookController(AuthorBookService authorBookService) {
        this.authorBookService = authorBookService;
    }


    @RequestMapping(value = "/authorbook")
    @ResponseBody
    public List<AuthorBook> authorList(Model model) {
        model.addAttribute("authorbook", new AuthorBook());
        model.addAttribute("getAuthorsBookList", this.authorBookService.getAuthorBookList());
        return authorBookService.getAuthorBookList();
    }


    @RequestMapping("/authorbook/{id}")
    @ResponseBody
    public String authorData(@PathVariable("id") String id) {
        return authorBookService.getAuthorBookById(Integer.parseInt(id)).toString();
    }

    @RequestMapping(value = "/authorbook/add", method = RequestMethod.POST)
    public String addAuthorBook(@ModelAttribute("authorbook") AuthorBook authorBook) {
        if (authorBook.getId() == 0) {
            authorBookService.addAuthorBook(authorBook);
        } else {
            authorBookService.updateAuthorBook(authorBook);
        }

        return "redirect:/authorbook";
    }

    @RequestMapping("authorbook/remove/{id}")
    public String removeAuthorBook(@PathVariable("id") String id) {
        authorBookService.removeAuthorBook(Integer.parseInt(id));
        return "redirect:/authors";
    }

    @RequestMapping("authorbook/edit/{id}")
    public String editAuthorBook(@PathVariable("id") String id, Model model) {
        model.addAttribute("author", authorBookService.getAuthorBookById(Integer.parseInt(id)));
        model.addAttribute("listAuthors", authorBookService.getAuthorBookList());
        return "authorbook";
    }
}
