package com.xiaotao.eshop.sso.service.impl;

import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.manager.mapper.UserMapper;
import com.xiaotao.eshop.manager.pojo.User;
import com.xiaotao.eshop.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by 13725 on 2018/4/11.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 校验身份问题
     *
     * @param param
     * @param type
     * @return
     */
    @Override
    public E3Result checkData(String param, int type) {

        User user = new User();
        switch (type) {
            case 1:
                user.setUsername(param);
                break;
            case 2:
                user.setPhone(param);
                break;
            case 3:
                user.setEmail(param);
                break;
        }
        List<User> users = userMapper.selectByUserInfo(user);
        if (users != null && users.size() > 0) {
            return E3Result.ok(false);
        } else {
            return E3Result.ok(true);
        }
    }

    @Transactional
    @Override
    public E3Result register(User user) {

        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

        userMapper.insert(user);
        return E3Result.ok(true);
    }
}
