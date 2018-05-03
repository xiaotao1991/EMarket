package com.xiaotao.eshop.sso.web.controller;

import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.manager.pojo.User;
import com.xiaotao.eshop.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 13725 on 2018/4/11.
 */
@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/page/register")
    public String showRegister() {
        return "register";
    }

    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public E3Result checkData(@PathVariable String param, @PathVariable Integer type) {
        return registerService.checkData(param, type);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public E3Result register(User user) {
        return registerService.register(user);
    }
}
