package com.xiaotao.eshop.sso.service.impl;

import com.xiaotao.common.jedis.JedisClient;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.common.utils.JsonUtils;
import com.xiaotao.eshop.manager.mapper.UserMapper;
import com.xiaotao.eshop.manager.pojo.User;
import com.xiaotao.eshop.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.UUID;

/**
 * Created by 13725 on 2018/4/11.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public E3Result userLogin(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        User backUser = userMapper.queryUserInfoByUsernameAndPassword(user);
        if (backUser != null) {
            String token = UUID.randomUUID().toString();
            backUser.setPassword("");
            jedisClient.set(token, JsonUtils.objectToJson(backUser));
            jedisClient.expire(token, 18000);  //设置超时时间
            return E3Result.ok(token);
        } else {
            return E3Result.build(400, "登录失败");
        }
    }
}
