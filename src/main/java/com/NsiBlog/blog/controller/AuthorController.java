package com.NsiBlog.blog.controller;

import com.NsiBlog.blog.dto.RestResponse;
import com.NsiBlog.blog.exception.AuthorDoesNotExists;
import com.NsiBlog.blog.exception.AuthorInputNullName;
import com.NsiBlog.blog.model.Author;
import com.NsiBlog.blog.service.AuthorService;
import com.NsiBlog.blog.service.implementation.AuthorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }


    @GetMapping
    public RestResponse<List<Author>> getAllAuthors(){
        List<Author> authors = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            List response = authorService.getAllAuthor();
            if(!response.isEmpty()){
                httpStatus = HttpStatus.OK;
                authors = response;
            } else {
                httpStatus = HttpStatus.NO_CONTENT;
            }
        }catch (Exception error){
            error.getCause();
            System.out.println("mensaje SMTP enviado");
        }
        return new RestResponse<>(httpStatus,authors);
    }


    @GetMapping("/filter/name")
    public RestResponse<List<Author>> getAuthorByName(@RequestBody Author author){
        List<Author> authors = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if(author.getName() == null)
            throw AuthorInputNullName.of(author);
        List response = authorService.getAuthorByName(author);
        if(response == null)
            throw AuthorDoesNotExists.of(author);
        httpStatus = HttpStatus.OK;
        authors = response;

        return new RestResponse<>(httpStatus, authors);
    }

    @GetMapping("/filter/surname")
    public RestResponse<List<Author>> getAuthorBySurname(@RequestBody Author author){
        List<Author> authors = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            List response = authorService.getAuthorBySurname(author);
            if(response != null){
                httpStatus = HttpStatus.OK;
                authors = response;
            } else {
                httpStatus = HttpStatus.NO_CONTENT;
            }
        }catch (Exception error){
            error.getCause();
            System.out.println("mensaje SMTP enviado");
        }
        return new RestResponse<>(httpStatus, authors);
    }

    @PostMapping
    public RestResponse<Integer> saveAuthor(@RequestBody Author author){
       int particularAuthor = 0;
       HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
       if (author.getEmail() == null || author.getName() == null || author.getSurname() == null|| author.getPassword() == null)
           throw AuthorInputNullName.of(author);
       int response = authorService.saveAuthor(author);
       if(response != 0){
          httpStatus = HttpStatus.OK;
          particularAuthor = response;
       }else{
           httpStatus = HttpStatus.PRECONDITION_FAILED;
       }
       //throw AuthorInputNullName;
       return new RestResponse<>(httpStatus, particularAuthor);
    }




}
