package com.NsiBlog.blog.repository;

import com.NsiBlog.blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


    String sql = "SELECT * FROM Author";
    @Query(value = sql, nativeQuery = true)
    List getAllAuthors();

    String sql2 = "SELECT * FROM Author WHERE name = :name";
    @Query(value = sql2, nativeQuery = true)
    Author getAuthorByName(@Param("name") String name);

    String sql3 = "INSERT INTO (name, surname, email, password) VALUES( :name, :surname, :email, :password) RETURNING id";
    @Query(value = sql3, nativeQuery = true)
    int saveAuthor(@Param("name") String name,
                      @Param("surname") String surname,
                      @Param("email") String email,
                      @Param("password") String password);



}
