package com.NsiBlog.blog.service.implementation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeServiceImplementationTest {

    @Autowired
    private BinarySearchTreeServiceImplementation binarySearchTreeServiceImplementation;


    @Test
    public void testing(){
        binarySearchTreeServiceImplementation.InstanceBST();
    }

}