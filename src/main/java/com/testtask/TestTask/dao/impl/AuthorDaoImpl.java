package com.testtask.TestTask.dao.impl;

import com.testtask.TestTask.dao.AuthorDao;
import com.testtask.TestTask.dao.rowMapper.AuthorRowMapper;
import com.testtask.TestTask.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAuthor(Author author) {
        String CREATE_AUTHOR_SQL = "INSERT INTO authors(name,born,gender) VALUES(?,?,?)";
        int update = jdbcTemplate.update(CREATE_AUTHOR_SQL, author.getName(), author.getBorn(), author.getGender());

        if (update == 1) {
            System.out.println("Author is created..");
        }
    }

    @Override
    public void updateAuthor(int id, String name) {
        String UPDATE_AUTHOR_SQL = "UPDATE authors set name=? WHERE aid=?";
        int update = jdbcTemplate.update(UPDATE_AUTHOR_SQL, name, id);
        if (update == 1) {
            System.out.println("Author name is Updated....");
        }
    }

    @Override
    public void removeAuthor(int id) {
        String DELETE_AUTHORS_SQL = "DELETE FROM authors WHERE aid=?";
        int update = jdbcTemplate.update(DELETE_AUTHORS_SQL, id);
        if (update == 1) {
            System.out.println("Author is Deleted......");
        }
    }

    @Override
    public Author getAuthorById(int id) {
        String GET_AUTHOR_SQL = "SELECT * FROM authors WHERE aid=?";
        return jdbcTemplate.queryForObject(GET_AUTHOR_SQL, new AuthorRowMapper(), id);
    }

    @Override
    public List<Author> getAuthorList() {
        String GET_AUTHORSLIST_SQL = "SELECT * FROM authors";
        RowMapper<Author> rowMapper = new AuthorRowMapper();
        return this.jdbcTemplate.query(GET_AUTHORSLIST_SQL, rowMapper);
    }

    @Override
    public List<Author> sortByBorn() {
        String GET_SORTBYBORN_SQL = "SELECT * FROM authors WHERE ((YEAR(CURDATE()) - YEAR(born)) > 55) order by born asc";
        RowMapper<Author> rowMapper = new AuthorRowMapper();
        return this.jdbcTemplate.query(GET_SORTBYBORN_SQL, rowMapper);
    }

    @Override
    public Author getMostAuthor() {
        String GET_MOSTAUTHOR_SQL = "Select * from authors where aid = (select authorbook.authorid from authorbook group by authorbook.authorid order by count(authorbook.authorid) desc LIMIT 1)";
        return jdbcTemplate.queryForObject(GET_MOSTAUTHOR_SQL, new AuthorRowMapper());
    }
}
