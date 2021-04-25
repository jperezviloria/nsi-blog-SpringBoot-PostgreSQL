package com.NsiBlog.blog.controller;

import com.NsiBlog.blog.dto.RestResponse;
import com.NsiBlog.blog.exception.AuthorInputNullName;
import com.NsiBlog.blog.model.Author;
import com.NsiBlog.blog.service.AuthorService;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AuthorControllerTest {

    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    private static Author regularAuthor =
            new Author(
                    "John",
                    "York",
                    "john@email.com",
                    "johnpass",
                    false);

    private static Author namedNullAuthor =
            new Author(
                    null,
                    "York",
                    "john@email.com",
                    "johnpass",
                    false);

    private static Author emailNullAuthor =
            new Author(
                    "John",
                    "York",
                    null,
                    "johnpass",
                    false);

    private static Author authorThatNameExist =
            new Author(
                    "Julio",
                    "Perez",
                    "julio@email.com",
                    "juliopass",
                    false);

    private static Author authorThatNameNotExist =
            new Author(
                    "Mike",
                    "Perez",
                    "mike@email.com",
                    "mikepass",
                    false);

    private static Author authorThatSurnameExist =
            new Author(
                    "Maria",
                    "Viloria",
                    "maria@email.com",
                    "mariapass",
                    false);

    private static Author authorThatSurnameNotExist =
            new Author(
                    "Alberto",
                    "Torres",
                    "alberto@email.com",
                    "albertopass",
                    false);


    @Before
    public void setup(){
        authorController = new AuthorController(authorService);
    }

    // Successful/HappyCase test
    @Test
    public void testThatStudentsCanBeGettingByName(){
        RestResponse<List<Author>> response = authorController.getAuthorByName(authorThatNameExist);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode());
    }




    // Test for expected exceptions
    //@Test(expected = AuthorInputNullName.class)
    @Test
    public void testThatInputNullNameCannotBeSaved(){
        doThrow(AuthorInputNullName.of(namedNullAuthor))
                .when(authorService)
                .saveAuthor(namedNullAuthor);

        authorController.saveAuthor(namedNullAuthor);
    }

}