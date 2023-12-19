package com.example.demo.controller;

import com.example.demo.domain.UserRegistirationForm;
import com.example.demo.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class WebController {

//    @Autowired
//    private UserRegistrationValidator userRegistrationValidator;
//
//
//    @InitBinder
//    public void dataBind(WebDataBinder dataBinder){
//        if(dataBinder.getTarget() != null &&
//        dataBinder.getTarget().getClass().equals(UserRegistirationForm.class)){
//            dataBinder.setValidator(userRegistrationValidator);
//        }
//    }
//
//    @GetMapping("/register")
//    public String newRegister(){
//        return "register";
//    }
//
//    @GetMapping("/login")
//    public String newLogin(){
//        return "login";
//    }
//
//    @GetMapping("/forgot-password")
//    public String newForgotPassword(){
//        return "forgot-password";
//    }


    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("register");
        UserRegistirationForm form= new UserRegistirationForm();
        mav.addObject("registrationForm", form);
        return mav;
    }
//    @PostMapping("/register")
//    public ModelAndView completeRegistration(@ModelAttribute("registrationForm") @Valid
//                                                 UserRegistirationForm registrationForm, BindingResult err){
//        ModelAndView mav= new ModelAndView();
//        System.out.println("Registration form="+registrationForm );
//
//        if (err.hasErrors()){
//            System.out.println("Formda problem var,  xeta sayi:"+err.getErrorCount());
//            err.getAllErrors().forEach(System.out::println);
//        }else{
//            System.out.println("Form ugurla basa catdi");
//        }
//
//        return mav;
//    }
}
