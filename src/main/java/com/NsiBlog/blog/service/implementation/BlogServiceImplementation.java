package com.NsiBlog.blog.service.implementation;

import com.NsiBlog.blog.model.Blog;
import com.NsiBlog.blog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImplementation implements BlogService {


    @Override
    public List getAllBlogs() {
        return null;
    }

    @Override
    public Blog[] getBlogsByAuthor(String nameAuthor) {
        return new Blog[0];
    }

    @Override
    public boolean changeAvailableById() {
        return false;
    }

    @Override
    public boolean changeTop() {
        return false;
    }

    @Override
    public String saveBlog(Blog blog) {
        return null;
    }

    @Override
    public String addLikeById(int idReader) {
        return null;
    }

    @Override
    public Blog[] getBlogsByTop() {
        return new Blog[0];
    }
}
