package com.NsiBlog.blog.exception;

import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    AUTHOR_BAD_PREREQUISITES(AuthorInputNullName.class, HttpStatus.PRECONDITION_FAILED),
    AUTHOR_NOT_FOUND(NullPointerException.class, HttpStatus.NOT_FOUND);

    private Class<? extends Throwable> exceptionClass;
    private HttpStatus status;
    private SupportedExceptions(Class<? extends Throwable>exception, HttpStatus status){
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class <? extends Throwable> getExceptionClass(){
        return this.exceptionClass;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}
