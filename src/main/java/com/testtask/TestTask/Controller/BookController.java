package com.testtask.TestTask.Controller;

import com.testtask.TestTask.Models.Book;
import com.testtask.TestTask.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public List<Book> bookList(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("getBooksList", this.bookService.getBooksList());
        List<Book> bookList = bookService.getBooksList();
        return bookList;
    }

//    @RequestMapping("/")
//    public ModelAndView dohome(){
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("listBooks",bookService.getBooksList());
//        return mv;
//    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String bookList(Model model) {
//        model.addAttribute("book", new Book());
//        model.addAttribute("getBookList", this.bookService.getBooksList());
//        return "bookList";

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getBook_id() == 0){
            this.bookService.addbook(book);
        }else {
            this.bookService.updatebook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int book_id){
        this.bookService.removebook(book_id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int book_id, Model model){
        model.addAttribute("book", this.bookService.getBookById(book_id));
        model.addAttribute("listBooks", this.bookService.getBooksList());

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.getBookById(id));

        return "bookdata";
    }
}

