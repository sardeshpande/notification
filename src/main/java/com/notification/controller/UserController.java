package com.notification.controller;

import com.notification.model.User;
import com.notification.repository.UserRepository;
import com.notification.service.UserService;
import com.notification.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping(value = "/adduser")
    public @ResponseBody String newUser(@RequestParam String name,@RequestParam String email,@RequestParam String contactNumber,@RequestParam String password)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setContactNumber(contactNumber);
        user.setPassword(password);
        userServiceImpl.adduser(user);
        return "User Added successfully";
    }

    @GetMapping(value = "/getuser")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @GetMapping(value = "/login")
    public @ResponseBody Boolean login(@RequestParam String email,@RequestParam String password){

        User user = (User) userServiceImpl.findUserbyemailId(email);
        String userPassword = user.getPassword();
        if(password.equals(userPassword)){
            return true;
        }
        return false;
    }

    @GetMapping(value = "/finduser")
    public @ResponseBody List<User> findUser(@RequestParam String email){

        User user = (User) userServiceImpl.findUserbyemailId(email);
        if(user != null) {
            return (List<User>) user;
        }
        return null;
    }
}
