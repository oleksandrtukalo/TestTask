package com.testtask.TestTask.Service;

import com.testtask.TestTask.Dao.AuthorDao;
import com.testtask.TestTask.Models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
   @Autowired
   private AuthorDao authorDao;

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDao.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDao.updateAuthor(author);
    }

    @Override
    @Transactional
    public void removeAuthor(int author_id) {
        this.authorDao.removeAuthor(author_id);
    }

    @Override
    @Transactional
    public Author getAuthorById(int author_id) {
        return this.authorDao.getAuthorById(author_id);
    }

    @Override
    @Transactional
    public List<Author> getAuthorList() {
        return this.authorDao.getAuthorList();
    }
}
