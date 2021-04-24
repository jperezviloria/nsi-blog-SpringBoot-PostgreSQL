package com.NsiBlog.blog.service.implementation;

import com.NsiBlog.blog.model.Author;
import com.NsiBlog.blog.repository.AuthorRepository;
import com.NsiBlog.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List getAllAuthor() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public Author getAuthorByName(Author author) {
        return authorRepository.getAuthorByName(author.getName());
    }

    @Override
    public int saveAuthor(Author author) {
        return authorRepository.saveAuthor(
                author.getName(),
                author.getSurname(),
                author.getEmail(),
                author.getPassword());
    }
}
