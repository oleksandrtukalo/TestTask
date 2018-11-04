package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.AuthorBook;

import java.util.List;

public interface AuthorBookDao {
    public void addAuthorBook(AuthorBook authorBook);

    public void updateAuthorBook(int id, int authorid);

    public void removeAuthorBook(int id);

    public AuthorBook getAuthorBookById(int id);

    public List<AuthorBook> getAuthorBookList();
}
