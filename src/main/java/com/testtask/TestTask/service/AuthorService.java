package com.testtask.TestTask.service;

import com.testtask.TestTask.models.Author;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author);

    public void updateAuthor(int id, String name);

    public void removeAuthor(int id);

    public Author getAuthorById(int id);

    public List<Author> getAuthorList();

    public List<Author> sortByBorn();

    public Author getMostAuthor();
}
