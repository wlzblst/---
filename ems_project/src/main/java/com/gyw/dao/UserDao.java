package com.gyw.dao;

import com.gyw.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserDao {

    void save(User user);

    User login(@Param("username") String username, @Param("password") String password);
}