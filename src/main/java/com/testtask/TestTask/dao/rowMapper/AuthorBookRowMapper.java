package com.testtask.TestTask.dao.rowMapper;

import com.testtask.TestTask.models.AuthorBook;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorBookRowMapper implements RowMapper<AuthorBook> {
    @Nullable
    @Override
    public AuthorBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        AuthorBook authorBook = new AuthorBook();
        authorBook.setId(rs.getInt("id"));
        authorBook.setAuthorid(rs.getInt("authorid"));
        authorBook.setBookid(rs.getInt("bookid"));
        return authorBook;
    }
}
