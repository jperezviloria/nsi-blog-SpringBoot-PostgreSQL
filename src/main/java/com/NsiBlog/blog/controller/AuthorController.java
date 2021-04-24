package com.NsiBlog.blog.controller;

import com.NsiBlog.blog.dto.RestResponse;
import com.NsiBlog.blog.model.Author;
import com.NsiBlog.blog.service.implementation.AuthorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {


    @Autowired
    AuthorServiceImplementation authorServiceImplementation;


    @GetMapping
    public RestResponse<List<Author>> getAllAuthors(){
        List<Author> authors = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            List<Author> response = authorServiceImplementation.getAllAuthor();
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
    public RestResponse<Author> getAuthorByName(@RequestBody Author author){
        Author particularAuthor = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            Author response = authorServiceImplementation.getAuthorByName(author);
            if(response != null){
                httpStatus = HttpStatus.OK;
                particularAuthor = response;
            } else {
                httpStatus = HttpStatus.NO_CONTENT;
            }
        }catch (Exception error){
            error.getCause();
            System.out.println("mensaje SMTP enviado");
        }
        return new RestResponse<>(httpStatus, particularAuthor);
    }

    @PostMapping
    public RestResponse<Integer> saveAuthor(@RequestBody Author author){
       int particularAuthor = 0;
       HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
       try{
           int response = authorServiceImplementation.saveAuthor(author);
           if(response != 0){
              httpStatus = HttpStatus.OK;
              particularAuthor = response;
           }else{
               httpStatus = HttpStatus.PRECONDITION_FAILED;
           }
       }catch (Exception error){
           error.getCause();
           System.out.println("mensaje SMTP enviado");
       }
       return new RestResponse<>(httpStatus, particularAuthor);
    }




}
