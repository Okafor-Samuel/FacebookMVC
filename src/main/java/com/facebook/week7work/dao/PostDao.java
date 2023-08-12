package com.facebook.week7work.dao;

import com.facebook.week7work.dto.PostDto;
import com.facebook.week7work.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Posts,Integer> {
    //@Query("SELECT q FROM Posts q ORDER BY q.id DESC")
    @Query(value = "SELECT * FROM posts q ORDER BY q.id DESC",nativeQuery = true)
    List<Posts> fetchPost();
}
