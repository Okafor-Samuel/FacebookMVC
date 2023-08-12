package com.facebook.week7work.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private int id;
    private String content;
    private String authorId;
    //private String title;
    private Integer likes;
    private String likedBy;
    private String dateCreated;

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", authorId='" + authorId + '\'' +
                ", likes=" + likes +
                ", likedBy='" + likedBy + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
