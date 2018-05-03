package com.xiaotao.eshop.sso.service;

import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.manager.pojo.User;

/**
 * Created by 13725 on 2018/4/11.
 */
public interface RegisterService {

    E3Result checkData(String param, int type);

    E3Result register(User user);

}
