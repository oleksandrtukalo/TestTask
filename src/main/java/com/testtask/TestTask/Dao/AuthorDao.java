package com.testtask.TestTask.Dao;

import com.testtask.TestTask.Models.Author;

import java.util.List;

public interface AuthorDao {
    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public void removeAuthor(int author_id);
    public Author getAuthorById(int author_id);
    public List<Author> getAuthorList();
}
