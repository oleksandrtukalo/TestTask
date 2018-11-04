package com.testtask.TestTask.service;

import com.testtask.TestTask.models.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void updateBook(int id,Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> getBookList();

    Integer getCalculateByGenre(String genre);

    List<Book> getTaskBookList();
}
