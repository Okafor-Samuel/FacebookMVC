package com.facebook.week7work.service;

import com.facebook.week7work.dao.PostDao;
import com.facebook.week7work.dao.UserDao;
import com.facebook.week7work.dto.PostDto;
import com.facebook.week7work.dto.UserDto;
import com.facebook.week7work.model.DeletePostDto;
import com.facebook.week7work.model.Posts;
import com.facebook.week7work.model.ResponseObject;
import com.facebook.week7work.model.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service

public class PostService {

    private final PostDao postDao;
    private final UserDao userDao;
    @Autowired
    public PostService(PostDao postDao,UserDao userDao){
        this.postDao=postDao;
        this.userDao=userDao;
    }

    private List<Posts> posts;
    private HashMap<Integer,String> authors;
    private List<Users> authorLists;
    public boolean save(Posts posts, HttpSession session){
        UserDto userDto =(UserDto)session.getAttribute("userDTO");
        LocalDateTime now = LocalDateTime.now();
        posts.setDateCreated(String.valueOf(now));
        posts.setAuthorId((userDto.getId()));
        postDao.save(posts);
        //fetchAuthors();
        this.posts=postDao.fetchPost();
        session.setAttribute("all_posts",this.postDao);
        return true;
    }
    public List<Posts> fetchPost(HttpSession session){
        posts=new ArrayList<>();
        posts= postDao.fetchPost();
        session.setAttribute("all_posts",posts);
        return posts;
    }

    public void fetchAuthors(){
        authorLists=new ArrayList<>();
        authorLists=userDao.fetchUser();
        //System.out.println(authorLists);
        authors=new HashMap<>();
        for(Users p:authorLists){
            authors.put(p.getId(),p.getFullName());
        }
    }

    public ResponseEntity<ResponseObject> deletePost(DeletePostDto deletePostDto) {
        postDao.deleteById(deletePostDto.getPostId());
        return new ResponseEntity(new ResponseObject(1,"Post successfully deleted"), HttpStatus.OK);

    }
}
