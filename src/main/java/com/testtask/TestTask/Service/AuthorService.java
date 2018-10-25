package com.testtask.TestTask.Service;

import com.testtask.TestTask.Models.Author;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public void removeAuthor(int author_id);
    public Author getAuthorById(int author_id);
    public List<Author> getAuthorList();
}
