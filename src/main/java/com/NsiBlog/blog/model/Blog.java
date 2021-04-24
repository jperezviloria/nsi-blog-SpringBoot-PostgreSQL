package com.NsiBlog.blog.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Blog {

    @Id
    private int id;

    private String title;

    private String content;

    private int idAuthor;

    private Date datePublish;

    private String urlImage;

    private String publicId;

    private boolean top;

    private boolean available;
}
