package com.testtask.TestTask.Service;

import com.testtask.TestTask.Dao.BookDaoImpl;
import com.testtask.TestTask.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDaoImpl bookDao;

    @Override
    @Transactional
    public void addbook(Book book) {
        this.bookDao.addbook(book);
    }

    @Override
    @Transactional
    public void updatebook(Book book) {
        this.bookDao.updatebook(book);
    }

    @Override
    @Transactional
    public void removebook(int book_id) {
        this.bookDao.removebook(book_id);
    }

    @Override
    public Book getBookById(int book_id) {
        return this.bookDao.getBookById(book_id);
    }

    @Override
    @Transactional
    public List<Book> getBooksList() {
        return this.bookDao.getBooksList();
    }

}
