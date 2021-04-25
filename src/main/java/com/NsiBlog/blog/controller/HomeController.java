package com.NsiBlog.blog.controller;

import com.NsiBlog.blog.service.implementation.HomeServiceImplementation;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {


    @Autowired
    HomeServiceImplementation homeServiceImplementation;


    /**
     * This API filtering numbers on List<String> in parallel
     * @return
     */
    @GetMapping
    public String concurrence(){
        return homeServiceImplementation.hello(ImmutableList.of("Hola","2","4", "que","7","tal"));
    }
}
