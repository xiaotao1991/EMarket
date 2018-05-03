package com.xiaotao.eshop.sso.web.controller;

import com.xiaotao.common.utils.CookieUtils;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 13725 on 2018/4/11.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/page/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public E3Result login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        E3Result e3Result = loginService.userLogin(username, password);
        //写入cookie
        if (e3Result.getStatus() == 200) {
            String token = e3Result.getData().toString();
            CookieUtils.setCookie(request, response, "token", token);
        }
        return e3Result;
    }
}
