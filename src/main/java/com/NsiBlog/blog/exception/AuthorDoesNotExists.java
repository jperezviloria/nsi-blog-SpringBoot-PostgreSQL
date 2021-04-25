package com.NsiBlog.blog.exception;

import com.NsiBlog.blog.model.Author;

public class AuthorDoesNotExists extends RuntimeException{

    public static AuthorDoesNotExists of (Author author){
        return new AuthorDoesNotExists(author);
    }


    public AuthorDoesNotExists(String customMessage){
        super(customMessage);
    }

    private AuthorDoesNotExists(Author author){
        super(String.format("This Author dont exist"));
    }


}
