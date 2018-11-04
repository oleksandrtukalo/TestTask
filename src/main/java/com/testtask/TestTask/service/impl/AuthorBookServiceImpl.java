package com.testtask.TestTask.service.impl;

import com.testtask.TestTask.dao.AuthorBookDao;
import com.testtask.TestTask.models.AuthorBook;
import com.testtask.TestTask.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    private final AuthorBookDao authorBookDao;

    @Autowired
    public AuthorBookServiceImpl(AuthorBookDao authorBookDao) {
        this.authorBookDao = authorBookDao;
    }


    @Override
    public void addAuthorBook(AuthorBook authorBook) {
        this.authorBookDao.addAuthorBook(authorBook);
    }

    @Override
    public void updateAuthorBook(int id, AuthorBook authorBook) {
        this.authorBookDao.updateAuthorBook(id, authorBook);
    }

    @Override
    public void removeAuthorBook(int id) {
        this.authorBookDao.removeAuthorBook(id);
    }

    @Override
    public AuthorBook getAuthorBookById(int id) {
        return this.authorBookDao.getAuthorBookById(id);
    }

    @Override
    public List<AuthorBook> getAuthorBookList() {
        return this.authorBookDao.getAuthorBookList();
    }
}
