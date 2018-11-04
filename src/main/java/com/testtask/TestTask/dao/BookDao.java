package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void updateBook(int id);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> getBookList();

    Integer getCalculateByGenre(String genre);

    List<Book> getTaskBookList();


}
