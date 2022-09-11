package com.example.javachallenge9.controller;


import com.example.javachallenge9.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAll(){
        return userService.findAll().stream().map(UserResponse::new).toList();
    }

    @GetMapping("/users/{id}")
    public List<UserResponse> getIds(@PathVariable("id") int id){
        return userService.count(id).stream().map(UserResponse::new).toList();
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(@RequestParam("teacher") String teacher){
        return userService.findById(teacher).stream().map(UserResponse::new).toList();
    }


}
