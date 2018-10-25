package com.testtask.TestTask.Models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "authors")
public class Author {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) private int author_id;

        @Column(name="AUTHORS_NAME") private String author_name;

        @Column(name="AUTHORS_GENDER") private String author_gender;

        @Temporal(TemporalType.DATE) @Column(name = "AUTHORS_BORN") private Date author_born;

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_gender() {
        return author_gender;
    }

    public void setAuthor_gender(String author_gender) {
        this.author_gender = author_gender;
    }

    public Date getAuthor_born() {
        return author_born;
    }

    public void setAuthor_born(Date author_born) {
        this.author_born = author_born;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", author_gender='" + author_gender + '\'' +
                ", author_born=" + author_born +
                '}';
    }
}
