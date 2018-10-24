package com.testtask.TestTask.Service;

import com.testtask.TestTask.Models.Book;

import java.util.List;

public interface BookService {
    public void addbook(Book book);
    public void updatebook(Book book);
    public void removebook(int book_id);
    public Book getBookById(int book_id);
    public List<Book> getBooksList();
}
