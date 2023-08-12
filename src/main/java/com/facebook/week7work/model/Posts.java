package com.facebook.week7work.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Integer authorId;//author_id

    @Column(nullable = false, length = 2048)
    private String content;

    @Column(columnDefinition = "integer default 0")
    private Integer likes;
    private String likedBy;
    @Column(nullable = false)
    private String dateCreated;

}
