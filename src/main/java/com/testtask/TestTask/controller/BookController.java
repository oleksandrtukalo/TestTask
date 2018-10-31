package com.testtask.TestTask.controller;

import com.testtask.TestTask.models.Book;
import com.testtask.TestTask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/books")
    @ResponseBody
    public List<Book> bookList(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("getBooksList", this.bookService.getBooksList());
        return bookService.getBooksList();
    }


    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookService.addbook(book);
        } else {
            bookService.updatebook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("books/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        bookService.removebook(id);

        return "redirect:/books";
    }

    @RequestMapping("books/edit/{id}")
    public ModelAndView editBook(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("books");
        Book book = bookService.getBookById(Integer.parseInt(id));
        List booksList = bookService.getBooksList();
        model.addObject("book", book);
        model.addObject("getBooksList", booksList);
        return model;
    }

    @RequestMapping("books/{id}")
    @ResponseBody
    public String bookData(@PathVariable("id") String id) {
        return this.bookService.getBookById(Integer.parseInt(id)).toString();

    }

}

