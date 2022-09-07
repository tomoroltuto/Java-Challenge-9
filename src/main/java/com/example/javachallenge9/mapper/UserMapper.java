package com.example.javachallenge9.mapper;

import com.example.javachallenge9.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    List<User> count(int id);

    @Select("SELECT * FROM users WHERE teacher = #{teacher}")
    List<User> findById(String teacher);

}
