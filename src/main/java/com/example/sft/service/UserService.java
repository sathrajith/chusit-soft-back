package com.example.sft.service;



import com.example.sft.entities.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    List<String> getAllUserEmails();
}