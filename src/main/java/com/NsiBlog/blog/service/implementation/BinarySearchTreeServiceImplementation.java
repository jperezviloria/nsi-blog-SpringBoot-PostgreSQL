package com.NsiBlog.blog.service.implementation;

import com.NsiBlog.blog.model.BinarySearchThree;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchTreeServiceImplementation {


    public void InstanceBST(){
        BinarySearchThree binarySearchThree = new BinarySearchThree();
        binarySearchThree.insert(5, "Hello WorLD");
        binarySearchThree.insert(2, -123);
        binarySearchThree.insert(1, null);
        binarySearchThree.insert(3, 1);
        binarySearchThree.insert(8, "asdlkj");
        binarySearchThree.insert(6, 5);
        binarySearchThree.insert(10, 70);

        binarySearchThree.inorderTreeWalk(binarySearchThree.branch);
    }

}
