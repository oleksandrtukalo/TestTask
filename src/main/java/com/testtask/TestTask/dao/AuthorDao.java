package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorDao extends CrudRepository<Author, Integer> {

    public List<Author> findByOrderByBornAsc();


}
