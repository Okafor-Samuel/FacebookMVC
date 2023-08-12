package com.facebook.week7work.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentDto {
    private int id;
    private String postId;//author_id
    private int authorId;
    private String content;

}
