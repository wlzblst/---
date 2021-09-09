package com.gyw.service;

import com.gyw.pojo.User;

public interface UserService {

    void save(User user);

    User login(String username, String password);
}