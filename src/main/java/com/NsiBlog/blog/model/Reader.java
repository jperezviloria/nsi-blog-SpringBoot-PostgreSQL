package com.NsiBlog.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Reader {



    @Id
    private int id;

    private String name;

    private boolean access;

}
