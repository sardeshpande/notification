package com.notification.service;

import com.notification.model.User;


import java.util.List;


public interface UserService {

    User adduser(User user);

    User findUserbyemailId(String email);

    List<User> getAllUsers();

}
