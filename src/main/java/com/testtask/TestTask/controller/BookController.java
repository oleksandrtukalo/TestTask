package com.testtask.TestTask.controller;

import com.testtask.TestTask.models.Book;
import com.testtask.TestTask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(value = "/all")
    public List<Book> bookList() {
        return bookService.getBookList();
    }


    @PostMapping(value = "/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @GetMapping("/{id}")
    public String bookData(@PathVariable("id") int id) {
        return bookService.getBookById(id).toString();
    }

    @GetMapping(value = "/calculate/{genre}")
    public Integer getCalculateByGenre(@PathVariable("genre") String genre) {
        return bookService.getCalculateByGenre(genre);
    }

    @GetMapping(value = "/taskList")
    public List<Book> bookTaskList(@ModelAttribute("book") Book book) {
        return bookService.getTaskBookList();
    }
}

