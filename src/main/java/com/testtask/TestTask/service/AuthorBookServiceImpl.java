package com.testtask.TestTask.service;

import com.testtask.TestTask.dao.AuthorBookDao;
import com.testtask.TestTask.models.AuthorBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    private final AuthorBookDao authorBookDao;

    @Autowired
    public AuthorBookServiceImpl(AuthorBookDao authorBookDao) {
        this.authorBookDao = authorBookDao;
    }

    @Override
    @Transactional
    public void addAuthorBook(AuthorBook authorBook) {
        this.authorBookDao.save(authorBook);
    }

    @Override
    @Transactional
    public void updateAuthorBook(AuthorBook authorBook) {
        this.authorBookDao.save(authorBook);
    }

    @Override
    @Transactional
    public void removeAuthorBook(int id) {
        this.authorBookDao.deleteById(id);
    }

    @Override
    @Transactional
    public AuthorBook getAuthorBookById(int id) {
        return this.authorBookDao.findById(id).get();
    }

    @Override
    @Transactional
    public List<AuthorBook> getAuthorBookList() {
        return (List<AuthorBook>) this.authorBookDao.findAll();
    }

}
