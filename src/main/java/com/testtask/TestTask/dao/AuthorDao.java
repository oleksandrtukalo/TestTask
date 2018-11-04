package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.Author;

import java.util.List;


public interface AuthorDao {
    void addAuthor(Author author);

    void updateAuthor(int id,Author author);

    void removeAuthor(int id);

    Author getAuthorById(int id);

    List<Author> getAuthorList();

    List<Author> sortByBorn();

    Author getMostAuthor();


}
