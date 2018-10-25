package com.testtask.TestTask.Controller;

import com.testtask.TestTask.Models.Author;
import com.testtask.TestTask.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors")
    @ResponseBody
    public List<Author> authorList(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("getAuthorsList", this.authorService.getAuthorList());
        List<Author> authorList = authorService.getAuthorList();
        return authorList;
    }
}
