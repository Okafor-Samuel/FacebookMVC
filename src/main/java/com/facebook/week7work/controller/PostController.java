package com.facebook.week7work.controller;

import com.facebook.week7work.model.Posts;
import com.facebook.week7work.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts/home")
    public ModelAndView posts(HttpSession session){
        postService.fetchPost(session);
        return new ModelAndView("home").addObject("postDto",new Posts());

    }
    @PostMapping("/posts/save")
    public String save(Posts posts, HttpSession session){
        //System.out.println(posts);
        postService.save(posts,session);
        return "redirect:/posts/home";
        //return new ModelAndView("home").addObject("postDto",new Posts());
    }


}

