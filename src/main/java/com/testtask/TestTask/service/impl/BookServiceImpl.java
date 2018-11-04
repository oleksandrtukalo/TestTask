package com.testtask.TestTask.service.impl;

import com.testtask.TestTask.dao.BookDao;
import com.testtask.TestTask.models.Book;
import com.testtask.TestTask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    public void updateBook(int id, String name) {
        this.bookDao.updateBook(id, name);
    }

    @Override
    public void removeBook(int id) {
        this.bookDao.removeBook(id);
    }

    @Override
    public Book getBookById(int id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    public List<Book> getBookList() {
        return this.bookDao.getBookList();
    }

    @Override
    public Integer getCalculateByGenre(String genre) {
        return this.bookDao.getCalculateByGenre(genre);
    }

    @Override
    public List<Book> getTaskBookList() {
        return this.bookDao.getTaskBookList();
    }
}
