package com.testtask.TestTask.Dao;

import com.testtask.TestTask.Models.Book;

import java.util.List;

public interface BookDao {
    public void addbook(Book book);
    public void updatebook(Book book);
    public void removebook(int id);
    public Book getBookById(int book_id);
    public List<Book> getBooksList();
}
