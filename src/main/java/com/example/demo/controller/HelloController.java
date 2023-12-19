package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
@RequestMapping("/")
public class HelloController
{
    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mav= new ModelAndView("hello");
        Random random= new Random();
        int randomNumber= random.nextInt(1000);
                mav.addObject("randomQiymet", randomNumber);

        return mav;
    }
}
