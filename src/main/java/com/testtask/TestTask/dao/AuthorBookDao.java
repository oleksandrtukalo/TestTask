package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.AuthorBook;
import org.springframework.data.repository.CrudRepository;

public interface AuthorBookDao extends CrudRepository<AuthorBook, Integer> {
}
