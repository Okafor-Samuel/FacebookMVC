package com.facebook.week7work.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
public class HomeController {

    @GetMapping("")
    public ModelAndView home(){
      return new ModelAndView("index");
    }

}
