package com.testtask.TestTask.controller;

import com.testtask.TestTask.models.Author;
import com.testtask.TestTask.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) throws ParseException {
        this.authorService = authorService;
    }


    @RequestMapping(value = "/authors")
    @ResponseBody
    public List<Author> authorList(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("getAuthorsList", this.authorService.getAuthorList());
        return authorService.getAuthorList();
    }

    @RequestMapping(value = "/authors/born")
    @ResponseBody
    public List<Author> findByOrderByBornAsc(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("born", this.authorService.findByOrderByBornAsc());
        return authorService.findByOrderByBornAsc();
    }


    @RequestMapping("/authors/{id}")
    @ResponseBody
    public String authorData(@PathVariable("id") String id) {
        return authorService.getAuthorById(Integer.parseInt(id)).toString();
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") Author author) {
        if (author.getId() == 0) {
            authorService.addAuthor(author);
        } else {
            authorService.updateAuthor(author);
        }

        return "redirect:/authors";
    }

    @RequestMapping("authors/remove/{id}")
    public String removeAuthor(@PathVariable("id") String id) {
        authorService.removeAuthor(Integer.parseInt(id));

        return "redirect:/authors";
    }

    @RequestMapping("authors/edit/{id}")
    public String editAuthors(@PathVariable("id") String id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(Integer.parseInt(id)));
        model.addAttribute("listAuthors", authorService.getAuthorList());

        return "authors";
    }
}
