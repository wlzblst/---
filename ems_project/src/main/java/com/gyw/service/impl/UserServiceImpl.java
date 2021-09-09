package com.gyw.service.impl;

import com.gyw.dao.UserDao;
import com.gyw.pojo.User;
import com.gyw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);

    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}