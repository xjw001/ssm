package com.xjw.service.serviceImpl;

import com.xjw.bean.User;
import com.xjw.dao.UserMapper;
import com.xjw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public int getMaxUserId() {
        return userMapper.getMaxUserId();
    }
}
