package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.Author;

import java.util.List;


public interface AuthorDao {
    public void addAuthor(Author author);

    public void updateAuthor(int id, String name);

    public void removeAuthor(int id);

    public Author getAuthorById(int id);

    public List<Author> getAuthorList();

    public List<Author> sortByBorn();

    public Author getMostAuthor();


}
