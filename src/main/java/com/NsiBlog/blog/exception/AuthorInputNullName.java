package com.NsiBlog.blog.exception;

import com.NsiBlog.blog.model.Author;

public class AuthorInputNullName extends RuntimeException {

    public static AuthorInputNullName of (Author author){
        return new AuthorInputNullName(author);
    }

    public AuthorInputNullName(String customMessage){
        super(customMessage);
    }

    private AuthorInputNullName(Author author){
        super(String.format("This Author can`t be enroll because need insert a Name"));
    }
}
