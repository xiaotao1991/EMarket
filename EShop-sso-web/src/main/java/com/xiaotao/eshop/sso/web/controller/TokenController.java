package com.xiaotao.eshop.sso.web.controller;

import com.xiaotao.common.utils.E3Result;
import com.xiaotao.common.utils.JsonUtils;
import com.xiaotao.eshop.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 13725 on 2018/4/11.
 */
@Controller
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/user/token/{token}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserByToken(@PathVariable String token, String callback) {

        if (StringUtils.isEmpty(callback)) {
            return JsonUtils.objectToJson(tokenService.getUserByToken(token));
        } else {
            //解决跨域请求
            return callback + "(" + JsonUtils.objectToJson(tokenService.getUserByToken(token)) + ")";
        }


    }
}
