package com.testtask.TestTask.service;

import com.testtask.TestTask.dao.BookDao;
import com.testtask.TestTask.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addbook(Book book) {
        bookDao.save(book);
    }

    @Override
    @Transactional
    public void updatebook(Book book) {
        bookDao.save(book);
    }

    @Override
    @Transactional
    public void removebook(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.findById(id).get();
    }

    @Override
    @Transactional
    public List<Book> getBooksList() {
        return (List<Book>) bookDao.findAll();
    }

}
