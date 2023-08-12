package com.facebook.week7work.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MyRequestData {
    private int authorId;
    private String comment;
}
