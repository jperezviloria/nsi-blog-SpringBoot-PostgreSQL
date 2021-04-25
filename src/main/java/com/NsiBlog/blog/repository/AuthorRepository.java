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
    List getAuthorByName(@Param("name") String name);

    String sql3 = "SELECT * FROM Author WHERE surname = :surname";
    @Query(value = sql3, nativeQuery = true)
    List getAuthorBySurname(@Param("surname") String surname);

    String sql4 = "INSERT INTO Author (name, surname, email, password) VALUES( :name, :surname, :email, :password) RETURNING id";
    @Query(value = sql4, nativeQuery = true)
    int saveAuthor(@Param("name") String name,
                      @Param("surname") String surname,
                      @Param("email") String email,
                      @Param("password") String password);

    @Query("SELECT email FROM Author " +
            "WHERE EXISTS " +
            "(SELECT email FROM Author " +
            "WHERE email = '?1')")
    String selectExistsEmail(String email);

}
