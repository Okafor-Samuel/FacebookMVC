package com.facebook.week7work.service;

import com.facebook.week7work.dao.CommentDao;
import com.facebook.week7work.dto.CommentDto;
import com.facebook.week7work.dto.UserDto;
import com.facebook.week7work.model.Comments;
import com.facebook.week7work.model.ResponseObject;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService{
    private final CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao){
        this.commentDao=commentDao;
    }
    public ResponseEntity<ResponseObject> saveComment(CommentDto commentDto){
        Comments comments=new Comments();
        comments.setLikes(0);
        comments.setPostId(commentDto.getPostId());
        comments.setContent(commentDto.getContent());
        LocalDateTime now = LocalDateTime.now();
        comments.setDateCreated(String.valueOf(now));
        comments.setAuthorId(commentDto.getAuthorId());
        System.out.println(comments);
        commentDao.save(comments);
        return new ResponseEntity(new ResponseObject(1,"Comment saved"), HttpStatus.OK);
    }
    public List<Comments> findAllByPostId(CommentDto commentDto) {
        return commentDao.findAllByPostId(commentDto.getPostId());
    }
}
