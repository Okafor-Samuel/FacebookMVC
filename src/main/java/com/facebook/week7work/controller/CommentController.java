package com.facebook.week7work.controller;

import com.facebook.week7work.dto.CommentDto;
import com.facebook.week7work.dto.MyRequestData;
import com.facebook.week7work.dto.UserDto;
import com.facebook.week7work.model.Comments;
import com.facebook.week7work.model.ResponseObject;
import com.facebook.week7work.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;
    @Autowired
    private CommentController(CommentService commentService){
        this.commentService=commentService;
    }

    @PostMapping(value="save", consumes = {"application/json"})
    public ResponseEntity<ResponseObject> saveComment(@RequestBody CommentDto commentDto){
        return commentService.saveComment(commentDto);
    }
    @PostMapping(value="pick", consumes = {"application/json"})
    public ResponseEntity<List<Comments>> pickComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity(commentService.findAllByPostId(commentDto),HttpStatus.OK);
    }

}
