package com.testtask.TestTask.models;

import javax.persistence.*;

@Entity
@Table(name = "authorbook")
public class AuthorBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookId")
    private int bookId;

    @Column(name = "authorId")
    private int authorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", authorId=" + authorId +
                '}';
    }
}
