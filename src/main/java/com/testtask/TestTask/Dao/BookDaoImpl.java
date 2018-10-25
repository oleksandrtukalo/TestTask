package com.testtask.TestTask.Dao;


import com.testtask.TestTask.Models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("BookDao")
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);


    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;

    @Override
    public void addbook(Book book) {
        session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book details:" + book);
    }

    @Override
    public void updatebook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully updated. Book details:" + book);
    }

    @Override
    public void removebook(int book_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, book_id);
        if (book!=null){
            session.delete(book);
        }
        logger.info("Book successfully deleted. Book details:" + book);
    }

    @Override
    public Book getBookById(int book_id) {

        session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, book_id);
        logger.info("Book successfully loaded. Book details: " + book);

        return book;

    }
////
    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getBooksList() {
        logger.info("Books are returned");
        session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();
        for(Book b : bookList){
            logger.info("BookList List::" + b);
        }

        return bookList;

    }
}
