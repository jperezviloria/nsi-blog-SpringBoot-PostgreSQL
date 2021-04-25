package com.NsiBlog.blog.model;

public class BinarySearchThree {

    public Node branch;

    public BinarySearchThree() {
        this.branch = null;
    }

    //inorder tree walk
    public void inorderTreeWalk(Node particularNode){
        if(particularNode != null){
            inorderTreeWalk(particularNode.leftValue);
            System.out.println(particularNode.key);
            inorderTreeWalk(particularNode.rightValue);
        }
    }

    public void insert(int key, Object value){
        Node node = new Node(key);
        node.value = value;

        if(branch == null){
            branch = node;
        }else{
            Node temporal = branch;
            while(temporal != null){
                node.father = temporal;
                if(node.key >= temporal.key){
                    temporal = temporal.rightValue;
                }else{
                    temporal = temporal.leftValue;
                }
            }
            if(node.key < node.father.key){
                node.father.leftValue = node;
            }else{
                node.father.rightValue = node;
            }
        }
    }

    private class Node{
        public Node father;
        public Node rightValue;
        public Node leftValue;
        public int key;
        public Object value;

        public Node(int key){
            this.key = key;
            this.rightValue = null;
            this.leftValue = null;
            this.father = null;
            this.value = null;
        }
    }
}
