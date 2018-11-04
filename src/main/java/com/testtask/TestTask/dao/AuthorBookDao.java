package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.AuthorBook;

import java.util.List;

public interface AuthorBookDao {
    void addAuthorBook(AuthorBook authorBook);

    void updateAuthorBook(int id);

    void removeAuthorBook(int id);

    AuthorBook getAuthorBookById(int id);

    List<AuthorBook> getAuthorBookList();
}
