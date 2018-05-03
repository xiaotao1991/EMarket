package com.xiaotao.eshop.manager.mapper;

import com.xiaotao.eshop.manager.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByUserInfo(User user);

    User queryUserInfoByUsernameAndPassword(User user);
}