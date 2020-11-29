package com.xjw.dao;

import com.xjw.bean.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int getMaxUserId();
}