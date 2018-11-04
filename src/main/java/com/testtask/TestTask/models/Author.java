package com.testtask.TestTask.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "born")
    private Date born;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "authorbook",
            joinColumns = {@JoinColumn(name = "aid")},
            inverseJoinColumns = {@JoinColumn(name = "bid")}
    )
    Set<Book> books = new HashSet<>();


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", born=" + born +
                '}';
    }
}
