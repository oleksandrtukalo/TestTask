package com.testtask.TestTask.dao.impl;

import com.testtask.TestTask.dao.BookDao;
import com.testtask.TestTask.dao.rowMapper.BookRowMapper;
import com.testtask.TestTask.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private final int MIN_NUMBER_OF_PROCESSED_ROWS = 1;

    private Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addBook(Book book) {
        String CREATE_BOOK_SQL = "INSERT INTO books(name,published,genre,rating) VALUES(?,?,?,?)";
        int numberAddedRows = jdbcTemplate.update(CREATE_BOOK_SQL, book.getName(), book.getPublished(), book.getGenre(), book.getRating());
        if (numberAddedRows >= MIN_NUMBER_OF_PROCESSED_ROWS) {
            logger.info("Book successfully added. Book details: " + book);
        }
    }

    @Override
    public void updateBook(int id, Book book) {
        String UPDATE_BOOK_SQL = "UPDATE books set name=?2,published=?2,genre=?2,rating=?2 WHERE bid=?1";
        int numberUpdatedRows = jdbcTemplate.update(UPDATE_BOOK_SQL, book, id);
        if (numberUpdatedRows >= MIN_NUMBER_OF_PROCESSED_ROWS) {
            logger.info("Book with id: " + id + " successfully updated");
        }
    }

    @Override
    public void removeBook(int id) {
        String DELETE_BOOK_SQL = "DELETE FROM books WHERE bid=?";
        int numberAffectedRows = jdbcTemplate.update(DELETE_BOOK_SQL, id);
        if (numberAffectedRows >= MIN_NUMBER_OF_PROCESSED_ROWS) {
            logger.info("Book with id: " + id + " successfully removed");
        }
    }

    @Override
    public Book getBookById(int id) {
        String GET_BOOK_SQL = "SELECT * FROM books WHERE bid=?";
        logger.info("Book with id: " + id + " successfully loaded.");
        return jdbcTemplate.queryForObject(GET_BOOK_SQL, new BookRowMapper(), id);
    }

    @Override
    public List<Book> getBookList() {
        String GET_BOOKSLIST_SQL = "SELECT * FROM books";
        RowMapper<Book> rowMapper = new BookRowMapper();
        logger.info("Book list successfully loaded");
        return jdbcTemplate.query(GET_BOOKSLIST_SQL, rowMapper);
    }

    @Override
    public Integer getCalculateByGenre(String genre) {
        String GET_CALCULATE_SQL = "SELECT COUNT(*) FROM books where genre='" + genre + "'";
        logger.info("Book list has calculated number of books by genre");
        return jdbcTemplate.queryForObject(GET_CALCULATE_SQL, Integer.class);
    }

    @Override
    public List<Book> getTaskBookList() {
        String GET_BOOKSTASKLIST_SQL = "select * from books where bid in (select bookid from authorbook where authorbook.authorid in (select authorid from authorbook group by authorbook.authorid  Having COUNT(authorbook.authorid) > 1 order by count(authorbook.authorid) desc))";
        RowMapper<Book> rowMapper = new BookRowMapper();
        logger.info("Book list has returned books whose author has more than 1 written book");
        return jdbcTemplate.query(GET_BOOKSTASKLIST_SQL, rowMapper);
    }
}
