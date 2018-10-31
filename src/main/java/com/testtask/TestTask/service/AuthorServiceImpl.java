package com.testtask.TestTask.service;

import com.testtask.TestTask.dao.AuthorDao;
import com.testtask.TestTask.models.Author;
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
        this.authorDao.save(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDao.save(author);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDao.deleteById(id);
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return this.authorDao.findById(id).get();
    }

    @Override
    @Transactional
    public List<Author> getAuthorList() {
        return (List<Author>) this.authorDao.findAll();
    }

    @Override
    public List<Author> findByOrderByBornAsc() {
        return this.authorDao.findByOrderByBornAsc();
    }


}
