package com.facebook.week7work.dao;

import com.facebook.week7work.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentDao extends JpaRepository<Comments, Integer> {
    List<Comments> findAllByPostId(String postId);
}
