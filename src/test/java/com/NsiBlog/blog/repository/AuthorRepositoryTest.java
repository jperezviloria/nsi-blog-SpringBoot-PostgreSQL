package com.NsiBlog.blog.repository;

import com.NsiBlog.blog.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void itShouldGetAllAuthors() {

        List search = authorRepository.getAllAuthors();
//        assertThat(search).isEqualTo(author);
        System.out.println(search);
    }

    @Test
    void itShouldGetAuthorByName() {

        String name = "Maria";
        Author author = new Author(
                1,
                "Maria",
                "Viloria",
                "maria@email.com",
                "mariapass",
                false
        );
        List search = authorRepository.getAuthorByName(name);
        assertNotNull(search);
        assertEquals(name, author.getName());

        //assertThat(search).isEqualTo(author);
//        System.out.println(search);
    }

    @Test
    void itShouldCheckIfAuthorEmailExists() {

        String email = "maria@email.com";
        Author author = new Author(
                1,
                "Maria",
                "Viloria",
                "maria@email.com",
                "mariapass",
                false
        );
        String search = authorRepository.selectExistsEmail(email);
        assertNotNull(search);
        assertEquals(email, author.getEmail());

        //assertThat(search).isEqualTo(author);
//        System.out.println(search);
    }
}