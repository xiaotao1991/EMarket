package com.xiaotao.eshop.sso.service;

import com.xiaotao.common.utils.E3Result;

/**
 * Created by 13725 on 2018/4/11.
 */
public interface LoginService {

    E3Result userLogin(String username, String password);

}
