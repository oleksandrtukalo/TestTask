package com.testtask.TestTask.dao.impl;

import com.testtask.TestTask.dao.AuthorBookDao;
import com.testtask.TestTask.dao.rowMapper.AuthorBookRowMapper;
import com.testtask.TestTask.models.AuthorBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorBookDaoImpl implements AuthorBookDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorBookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAuthorBook(AuthorBook authorBook) {
        String CREATE_AUTHORBOOK_SQL = "INSERT INTO authorbook(authorid,bookid) VALUES(?,?)";

        int update = jdbcTemplate.update(CREATE_AUTHORBOOK_SQL, authorBook.getAuthorid(), authorBook.getBookid());

        if (update == 1) {
            System.out.println("AuthorBook is created..");
        }
    }

    @Override
    public void updateAuthorBook(int id, int authorid) {
        String UPDATE_AUTHORBOOK_SQL = "UPDATE authorbook set authorid=? WHERE id=?";
        int update = jdbcTemplate.update(UPDATE_AUTHORBOOK_SQL, authorid, id);
        if (update == 1) {
            System.out.println("AuthorBook name is Updated....");
        }
    }

    @Override
    public void removeAuthorBook(int id) {
        String DELETE_AUTHORBOOK_SQL = "DELETE FROM authorbook WHERE id=?";
        int update = jdbcTemplate.update(DELETE_AUTHORBOOK_SQL, id);
        if (update == 1) {
            System.out.println("AuthorBook is Deleted......");
        }
    }

    @Override
    public AuthorBook getAuthorBookById(int id) {
        String GET_AUTHORBOOK_SQL = "SELECT * FROM authorbook WHERE id=?";
        return jdbcTemplate.queryForObject(GET_AUTHORBOOK_SQL, new AuthorBookRowMapper(), id);
    }

    @Override
    public List<AuthorBook> getAuthorBookList() {
        String GET_AUTHORBOOKLIST_SQL = "SELECT * FROM authorbook";
        RowMapper<AuthorBook> rowMapper = new AuthorBookRowMapper();
        return this.jdbcTemplate.query(GET_AUTHORBOOKLIST_SQL, rowMapper);
    }
}
