package com.testtask.TestTask.service;

import com.testtask.TestTask.models.AuthorBook;

import java.util.List;

public interface AuthorBookService {
    public void addAuthorBook(AuthorBook authorBook);

    public void updateAuthorBook(AuthorBook authorBook);

    public void removeAuthorBook(int id);

    public AuthorBook getAuthorBookById(int id);

    public List<AuthorBook> getAuthorBookList();

}
