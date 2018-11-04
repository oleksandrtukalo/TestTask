package com.testtask.TestTask.dao.impl;

import com.testtask.TestTask.dao.AuthorDao;
import com.testtask.TestTask.dao.rowMapper.AuthorRowMapper;
import com.testtask.TestTask.models.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    private final int MIN_NUMBER_OF_AFFECTED_ROWS = 1;
    private final int MIN_NUMBER_OF_UPDATED_ROWS = 1;
    private final int MIN_NUMBER_OF_ADDED_ROWS = 1;
    Logger logger = LoggerFactory.getLogger(AuthorDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAuthor(Author author) {
        String CREATE_AUTHOR_SQL = "INSERT INTO authors(name,born,gender) VALUES(?,?,?)";
        int numberAddedRows = jdbcTemplate.update(CREATE_AUTHOR_SQL, author.getName(), author.getBorn(), author.getGender());

        if (numberAddedRows >= MIN_NUMBER_OF_ADDED_ROWS) {
            logger.info("Author successfully added. Author details: " + author);
        }
    }

    @Override
    public void updateAuthor(int id) {
        String UPDATE_AUTHOR_SQL = "UPDATE authors set name=?,gender=?,born=? WHERE aid=?";
        int numberUpdatedRows = jdbcTemplate.update(UPDATE_AUTHOR_SQL,id);
        if (numberUpdatedRows >= MIN_NUMBER_OF_UPDATED_ROWS) {
            logger.info("Author with id: " + id + " successfully updated");
        }
    }

    @Override
    public void removeAuthor(int id) {
        String DELETE_AUTHORS_SQL = "DELETE FROM authors WHERE aid=?";
        int numberAffectedRows = jdbcTemplate.update(DELETE_AUTHORS_SQL, id);
        if (numberAffectedRows >= MIN_NUMBER_OF_AFFECTED_ROWS) {
            logger.info("Author with id: " + id + " successfully removed");
        }
    }

    @Override
    public Author getAuthorById(int id) {
        String GET_AUTHOR_SQL = "SELECT * FROM authors WHERE aid=?";
        logger.info("Author with id: " + id + " successfully loaded.");
        return jdbcTemplate.queryForObject(GET_AUTHOR_SQL, new AuthorRowMapper(), id);
    }

    @Override
    public List<Author> getAuthorList() {
        String GET_AUTHORSLIST_SQL = "SELECT * FROM authors";
        RowMapper<Author> rowMapper = new AuthorRowMapper();
        logger.info("Author list successfully loaded");
        return this.jdbcTemplate.query(GET_AUTHORSLIST_SQL, rowMapper);
    }

    @Override
    public List<Author> sortByBorn() {
        String GET_SORTBYBORN_SQL = "SELECT * FROM authors WHERE ((YEAR(CURDATE()) - YEAR(born)) > 55) order by born asc";
        RowMapper<Author> rowMapper = new AuthorRowMapper();
        logger.info("Author list has sorted and successfully loaded");
        return this.jdbcTemplate.query(GET_SORTBYBORN_SQL, rowMapper);
    }

    @Override
    public Author getMostAuthor() {
        String GET_MOSTAUTHOR_SQL = "Select * from authors where aid = (select authorbook.authorid from authorbook group by authorbook.authorid order by count(authorbook.authorid) desc LIMIT 1)";
        logger.info("The author who has most of the books has been found and successfully loaded");
        return jdbcTemplate.queryForObject(GET_MOSTAUTHOR_SQL, new AuthorRowMapper());
    }
}
