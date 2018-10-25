package com.testtask.TestTask.Dao;

import com.testtask.TestTask.Models.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AuthorDao")
public class AuthorDaoImpl implements AuthorDao {
    private static final Logger logger = LoggerFactory.getLogger(AuthorDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;

    @Override
    public void addAuthor(Author author) {
        session = this.sessionFactory.getCurrentSession();
        session.persist(author);
        logger.info("Book successfully saved. Book details:" + author);
    }

    @Override
    public void updateAuthor(Author author) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(author);
        logger.info("Book successfully updated. Book details:" + author);
    }

    @Override
    public void removeAuthor(int author_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Author author = (Author) session.load(Author.class, author_id);
        if (author!=null){
            session.delete(author);
        }
        logger.info("Book successfully deleted. Book details:" + author);
    }

    @Override
    public Author getAuthorById(int author_id) {
        session = this.sessionFactory.getCurrentSession();
        Author author = (Author) session.load(Author.class, author_id);
        logger.info("Book successfully loaded. Book details: " + author);

        return author;
    }

    @Override
    public List<Author> getAuthorList() {
        logger.info("Books are returned");
        session = this.sessionFactory.getCurrentSession();
        List authorList = session.createQuery("from Author").list();
        for(Object a : authorList){
            logger.info("BookList List::" + a);
        }

        return authorList;
    }
}
