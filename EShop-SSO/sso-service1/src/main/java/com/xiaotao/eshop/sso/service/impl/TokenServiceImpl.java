package com.xiaotao.eshop.sso.service.impl;

import com.xiaotao.common.jedis.JedisClient;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.common.utils.JsonUtils;
import com.xiaotao.eshop.manager.pojo.User;
import com.xiaotao.eshop.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by 13725 on 2018/4/11.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JedisClient jedisClient;

    @Override
    public E3Result getUserByToken(String token) {
        String json = jedisClient.get(token);
        if (StringUtils.isEmpty(json)) {
            return E3Result.build(201, "用户登录过期");
        }
        jedisClient.expire(token, 64000); //重新设置超时时间
        User user = JsonUtils.jsonToPojo(json, User.class);
        return E3Result.ok(user);
    }
}
