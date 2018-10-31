package com.testtask.TestTask.service;

import com.testtask.TestTask.models.Book;

import java.util.List;

public interface BookService {
    public void addbook(Book book);

    public void updatebook(Book book);

    public void removebook(int id);

    public Book getBookById(int id);

    public List<Book> getBooksList();
}
