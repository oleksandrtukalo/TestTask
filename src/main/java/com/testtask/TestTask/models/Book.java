package com.testtask.TestTask.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BOOK_NAME")
    private String book_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "BOOK_PUBLISHED")
    private Date book_published;

    @Column(name = "BOOK_GENRE")
    private String book_genre;
    @Column(name = "BOOK_RATING")
    private int book_rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Date getBook_published() {
        return book_published;
    }

    public void setBook_published(Date book_published) {
        this.book_published = book_published;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }

    public int getBook_rating() {
        return book_rating;
    }

    public void setBook_rating(int book_rating) {
        this.book_rating = book_rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", book_published=" + book_published +
                ", book_genre='" + book_genre + '\'' +
                ", book_rating=" + book_rating +
                '}';
    }
}
