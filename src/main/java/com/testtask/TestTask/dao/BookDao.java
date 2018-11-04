package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.Book;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);

    public void updateBook(int id, String name);

    public void removeBook(int id);

    public Book getBookById(int id);

    public List<Book> getBookList();

    public Integer getCalculateByGenre();
    public List<Book> getTaskBookList();


}
