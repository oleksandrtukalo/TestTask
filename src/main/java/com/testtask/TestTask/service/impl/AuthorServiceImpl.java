package com.testtask.TestTask.service.impl;

import com.testtask.TestTask.dao.AuthorDao;
import com.testtask.TestTask.models.Author;
import com.testtask.TestTask.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDao.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(int id, String name) {
        this.authorDao.updateAuthor(id, name);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDao.removeAuthor(id);
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return this.authorDao.getAuthorById(id);
    }

    @Override
    @Transactional
    public List<Author> getAuthorList() {
        return (List<Author>) this.authorDao.getAuthorList();
    }

    @Override
    public List<Author> sortByBorn() {
        return this.authorDao.sortByBorn();
    }

    @Override
    public Author getMostAuthor() {
        return this.authorDao.getMostAuthor();
    }


}
