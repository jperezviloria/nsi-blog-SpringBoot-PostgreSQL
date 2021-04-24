package com.NsiBlog.blog.service;

import com.NsiBlog.blog.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {


    List getAllAuthor();

    Author getAuthorByName(Author author);

    int saveAuthor(Author author);

}
