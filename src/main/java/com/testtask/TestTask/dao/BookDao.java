package com.testtask.TestTask.dao;

import com.testtask.TestTask.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {


}
