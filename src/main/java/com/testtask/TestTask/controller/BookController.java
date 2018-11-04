package com.testtask.TestTask.controller;

import com.testtask.TestTask.models.Book;
import com.testtask.TestTask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Book> bookList(@ModelAttribute("book") Book book) {
        return bookService.getBookList();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
    }

    @RequestMapping("/remove/{id}")
    public void removeBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
    }

    @RequestMapping("/update/{id}")
    public void updateBook(@PathVariable("id") int id, String name) {
        bookService.updateBook(id, name);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String bookData(@PathVariable("id") int id) {
        return bookService.getBookById(id).toString();
    }

    @RequestMapping(value = "/calculate/{genre}")
    @ResponseBody
    public Integer getCalculateByGenre(@PathVariable("genre") String genre) {
        return bookService.getCalculateByGenre(genre);
    }

    @RequestMapping(value = "/tasklist")
    @ResponseBody
    public List<Book> bookTaskList(@ModelAttribute("book") Book book) {
        return bookService.getTaskBookList();
    }
}

