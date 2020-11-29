package com.xjw.service;

import com.xjw.bean.User;

import java.util.List;

public interface UserService {

    public  void addUser(User user);

    List<User> getAllUsers();

    void saveUser(User user);
}
