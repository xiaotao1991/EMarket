package com.xiaotao.eshop.content.service.impl;

import com.xiaotao.common.jedis.JedisClient;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.common.utils.JsonUtils;
import com.xiaotao.eshop.content.service.ContentService;
import com.xiaotao.eshop.manager.mapper.ContentMapper;
import com.xiaotao.eshop.manager.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by 13725 on 2018/4/9.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public E3Result addContent(Content content) {

        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);
        return E3Result.ok();
    }

    @Override
    public List<Content> getContentListByCid(long cid) {
        //先查询缓存
        try {
            String value = jedisClient.hget("CONTENT_LIST", cid + "");
            if (!StringUtils.isEmpty(value)) {
                return JsonUtils.jsonToList(value, Content.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Content> contents = contentMapper.queryContentListByCid(cid);
        try {
            jedisClient.hset("CONTENT_LIST", cid + "", JsonUtils.objectToJson(contents));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }
}
