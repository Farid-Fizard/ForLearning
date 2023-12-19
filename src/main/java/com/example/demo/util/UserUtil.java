package com.example.demo.util;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRegistirationForm;
import com.example.demo.domain.UserStatus;

public class UserUtil {
    public static User getUser(UserRegistirationForm form){
        User user= new User();
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setEmail(form.getEmail());
        user.setMobile(form.getPhone());
        user.setPassword(form.getPassword());
        user.setRole(Role.USER);
        user.setUserStatus(UserStatus.PENDING);
        return user;
    }
}
