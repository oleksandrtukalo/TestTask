package com.testtask.TestTask.dao.rowMapper;


import com.testtask.TestTask.models.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {
    @Nullable
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setaId(rs.getInt("aid"));
        author.setName(rs.getString("name"));
        author.setBorn(rs.getDate("born"));
        author.setGender(rs.getString("gender"));
        return author;
    }
}
