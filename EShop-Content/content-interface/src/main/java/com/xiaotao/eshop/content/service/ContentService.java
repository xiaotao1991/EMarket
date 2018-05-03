package com.xiaotao.eshop.content.service;

import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.manager.pojo.Content;

import java.util.List;

/**
 * Created by 13725 on 2018/4/9.
 */
public interface ContentService {

    E3Result addContent(Content content);

    List<Content> getContentListByCid(long cid);
}
