package com.testtask.TestTask.models;

import javax.persistence.*;

@Entity
@Table(name = "authorbook")
public class AuthorBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookid")
    private int bookid;

    @Column(name = "authorid")
    private int authorid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", authorid=" + authorid +
                '}';
    }
}
