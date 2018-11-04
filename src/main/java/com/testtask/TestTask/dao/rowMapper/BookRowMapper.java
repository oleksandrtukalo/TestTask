package com.testtask.TestTask.dao.rowMapper;

import com.testtask.TestTask.models.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Nullable
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setbId(rs.getInt("bid"));
        book.setName(rs.getString("name"));
        book.setPublished(rs.getDate("published"));
        book.setGenre(rs.getString("genre"));
        book.setRating(rs.getInt("rating"));
        return book;
    }
}
