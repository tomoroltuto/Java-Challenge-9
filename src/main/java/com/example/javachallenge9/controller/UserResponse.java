package com.example.javachallenge9.controller;

import com.example.javachallenge9.entity.User;

public class UserResponse {
    private int id;
    private String name;
    private String teacher;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.teacher = user.getTeacher();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
