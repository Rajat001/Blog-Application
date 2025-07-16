package com.codewithdurgesh.blog.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title" , length = 100 , nullable = false)
    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    private Category category; // this will be linked to Category table having its id .

    @ManyToOne
    private User user ; // this will be linked to User table having its id .
}
