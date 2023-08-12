package com.facebook.week7work.controller;

import com.facebook.week7work.model.DeletePostDto;
import com.facebook.week7work.model.ResponseObject;
import com.facebook.week7work.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("delete")
public class DeleteController {

    private final PostService postService;

    @Autowired
    public DeleteController(PostService postService){
        this.postService=postService;
    }

    @PostMapping ("post")
    public ResponseEntity<ResponseObject> deletePost(@RequestBody DeletePostDto deletePostDto){
       return postService.deletePost(deletePostDto);
    }
}
