package com.facebook.week7work.controller;

import com.facebook.week7work.dto.LoginDto;
import com.facebook.week7work.dto.UserDto;
import com.facebook.week7work.model.Users;
import com.facebook.week7work.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/login")
    public ModelAndView login(){
        return new ModelAndView("login").addObject("loginDto",new LoginDto());
    }

    @GetMapping("/user/signup")
    public ModelAndView signUp(){
        return new ModelAndView( "signup").addObject("userDto",new Users());
    }
    @PostMapping("/users/save_user")
    public String saveUser(Users user, HttpSession session){
        userService.save(user,session);
        //System.out.println(user);
        return "redirect:/user/login";
    }
    @PostMapping("/user/login")
    public String auth(LoginDto loginDto, HttpSession session){
        if(userService.auth(loginDto, session)){
            session.setAttribute("login_status","Success");
            return "redirect:/posts/home";
        }
        session.setAttribute("login_status","Invalid login credentials");
        return "redirect:/user/login";
    }
}
