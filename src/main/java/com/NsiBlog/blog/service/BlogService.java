package com.NsiBlog.blog.service;

import com.NsiBlog.blog.model.Blog;

import java.util.List;

public interface BlogService {

    List getAllBlogs ();

    Blog[] getBlogsByAuthor(String nameAuthor);

    boolean changeAvailableById();

    boolean changeTop();

    String saveBlog(Blog blog);

    String addLikeById(int idReader);

    Blog[] getBlogsByTop();





}
