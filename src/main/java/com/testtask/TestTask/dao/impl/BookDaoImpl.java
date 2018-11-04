package com.testtask.TestTask.dao.impl;

import com.testtask.TestTask.dao.BookDao;
import com.testtask.TestTask.dao.rowMapper.BookRowMapper;
import com.testtask.TestTask.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addBook(Book book) {
        String CREATE_BOOK_SQL = "INSERT INTO books(name,published,genre,rating) VALUES(?,?,?,?)";
        int update = jdbcTemplate.update(CREATE_BOOK_SQL, book.getName(), book.getPublished(), book.getGenre(), book.getRating());
        if (update == 1) {
            System.out.println("Book is created..");
        }
    }

    @Override
    public void updateBook(int id, String name) {
        String UPDATE_BOOK_SQL = "UPDATE books set name=? WHERE bid=?";
        int update = jdbcTemplate.update(UPDATE_BOOK_SQL, name, id);
        if (update == 1) {
            System.out.println("Book name is Updated....");
        }
    }

    @Override
    public void removeBook(int id) {
        String DELETE_BOOK_SQL = "DELETE FROM books WHERE bid=?";
        int update = jdbcTemplate.update(DELETE_BOOK_SQL, id);
        if (update == 1) {
            System.out.println("Book is Deleted......");
        }
    }

    @Override
    public Book getBookById(int id) {
        String GET_BOOK_SQL = "SELECT * FROM books WHERE bid=?";
        return jdbcTemplate.queryForObject(GET_BOOK_SQL, new BookRowMapper(), id);
    }

    @Override
    public List<Book> getBookList() {
        String GET_BOOKSLIST_SQL = "SELECT * FROM books";
        RowMapper<Book> rowMapper = new BookRowMapper();
        return jdbcTemplate.query(GET_BOOKSLIST_SQL, rowMapper);
    }

    @Override
    public Integer getCalculateByGenre(String genre) {
        String GET_CALCULATE_SQL = "SELECT COUNT(*) FROM books where genre='" + genre + "'";
        return jdbcTemplate.queryForObject(GET_CALCULATE_SQL, Integer.class);
    }

    @Override
    public List<Book> getTaskBookList() {
        String GET_BOOKSTASKLIST_SQL = "select * from books where bid in (select bookid from authorbook where authorbook.authorid in (select authorid from authorbook group by authorbook.authorid  Having COUNT(authorbook.authorid) > 1 order by count(authorbook.authorid) desc))";
        RowMapper<Book> rowMapper = new BookRowMapper();
        return jdbcTemplate.query(GET_BOOKSTASKLIST_SQL, rowMapper);
    }
}
