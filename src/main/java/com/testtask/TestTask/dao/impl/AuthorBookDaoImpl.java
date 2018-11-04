package com.testtask.TestTask.dao.impl;

import com.testtask.TestTask.dao.AuthorBookDao;
import com.testtask.TestTask.dao.rowMapper.AuthorBookRowMapper;
import com.testtask.TestTask.models.AuthorBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorBookDaoImpl implements AuthorBookDao {
    private final int MIN_NUMBER_OF_AFFECTED_ROWS = 1;
    private final int MIN_NUMBER_OF_UPDATED_ROWS = 1;
    private final int MIN_NUMBER_OF_ADDED_ROWS = 1;
    Logger logger = LoggerFactory.getLogger(AuthorBookDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public AuthorBookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAuthorBook(AuthorBook authorBook) {
        String CREATE_AUTHORBOOK_SQL = "INSERT INTO authorbook(authorid,bookid) VALUES(?,?)";
        int numberAddedRows = jdbcTemplate.update(CREATE_AUTHORBOOK_SQL, authorBook.getAuthorId(), authorBook.getBookId());
        if (numberAddedRows >= MIN_NUMBER_OF_ADDED_ROWS) {
            logger.info("AuthorBook successfully added. AuthorBook  details: " + authorBook);
        }
    }

    @Override
    public void updateAuthorBook(int id) {
        String UPDATE_AUTHORBOOK_SQL = "UPDATE authorbook set authorid=?,bookid=? WHERE id=?";
        int numberUpdatedRows = jdbcTemplate.update(UPDATE_AUTHORBOOK_SQL, id);
        if (numberUpdatedRows >= MIN_NUMBER_OF_UPDATED_ROWS) {
            logger.info("AuthorBook with id: " + id + " successfully updated");
        }
    }

    @Override
    public void removeAuthorBook(int id) {
        String DELETE_AUTHORBOOK_SQL = "DELETE FROM authorbook WHERE id=?";
        int numberAffectedRows = jdbcTemplate.update(DELETE_AUTHORBOOK_SQL, id);
        if (numberAffectedRows >= MIN_NUMBER_OF_AFFECTED_ROWS) {
            logger.info("AuthorBook with id: " + id + " successfully removed");
        }
    }

    @Override
    public AuthorBook getAuthorBookById(int id) {
        String GET_AUTHORBOOK_SQL = "SELECT * FROM authorbook WHERE id=?";
        logger.info("AuthorBook with id: " + id + " successfully loaded.");
        return jdbcTemplate.queryForObject(GET_AUTHORBOOK_SQL, new AuthorBookRowMapper(), id);
    }

    @Override
    public List<AuthorBook> getAuthorBookList() {
        String GET_AUTHORBOOKLIST_SQL = "SELECT * FROM authorbook";
        RowMapper<AuthorBook> rowMapper = new AuthorBookRowMapper();
        logger.info("AuthorBook list successfully loaded");
        return this.jdbcTemplate.query(GET_AUTHORBOOKLIST_SQL, rowMapper);
    }
}
