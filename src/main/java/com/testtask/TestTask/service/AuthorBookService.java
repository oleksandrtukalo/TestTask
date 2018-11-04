package com.testtask.TestTask.service;

import com.testtask.TestTask.models.AuthorBook;

import java.util.List;

public interface AuthorBookService {
    void addAuthorBook(AuthorBook authorBook);

    void updateAuthorBook(int id,AuthorBook authorBook);

    void removeAuthorBook(int id);

    AuthorBook getAuthorBookById(int id);

    List<AuthorBook> getAuthorBookList();

}
