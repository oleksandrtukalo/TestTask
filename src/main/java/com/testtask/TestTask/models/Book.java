package com.testtask.TestTask.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "published")
    private Date published;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private int rating;

    //    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
//
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", bid=" + bid +
                ", name='" + name + '\'' +
                ", published=" + published +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
