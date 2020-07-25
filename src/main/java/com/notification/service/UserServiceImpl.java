package com.notification.service;

import com.notification.model.User;
import com.notification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User adduser(User user) {
        return  userRepository.save(user);

    }

    @Override
    public User findUserbyemailId(String email) {
        return userRepository.findByemail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }


}
