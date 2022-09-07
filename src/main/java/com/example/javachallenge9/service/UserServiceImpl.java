package com.example.javachallenge9.service;

import com.example.javachallenge9.entity.User;
import com.example.javachallenge9.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> count(int id){
        return userMapper.count(id);
    }
    @Override
    public List<User> findById(String teacher){
        return userMapper.findById(teacher);
    }
}
