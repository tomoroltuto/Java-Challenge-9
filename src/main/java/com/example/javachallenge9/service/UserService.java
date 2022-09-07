package com.example.javachallenge9.service;

import com.example.javachallenge9.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> count(int id) ;

    List<User> findById(String teacher);

}
