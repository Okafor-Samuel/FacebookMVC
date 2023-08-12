package com.facebook.week7work.service;

import com.facebook.week7work.dao.UserDao;
import com.facebook.week7work.dto.LoginDto;
import com.facebook.week7work.dto.PostDto;
import com.facebook.week7work.dto.UserDto;
import com.facebook.week7work.model.Users;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    UserDto userDto;

    @Autowired
    PostService postService;

    public boolean save(Users user, HttpSession session){
        String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(password);
        userDao.save(user);
        session.setAttribute("account_status", "Account has been successfully created. Pls. login");
        return true;
    }
    public Users getUser(String email, String password){
        Users users=userDao.findByEmail(email);
        return users;
    }
    public boolean auth(LoginDto loginDto, HttpSession session){
        Users user = userDao.findByEmail(loginDto.getEmail());
        if(user!=null){
            if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
                //CREATE USER DTo
                userDto=new UserDto();
                userDto.setEmail(user.getEmail());
                userDto.setFullName(user.getFullName());
                userDto.setId(user.getId());
                postService.fetchPost(session);
                session.setAttribute("userDTO",userDto);
                session.setAttribute("loggedInUser",userDto.getFullName());
                session.setAttribute("loggedInId",userDto.getId());
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
}
