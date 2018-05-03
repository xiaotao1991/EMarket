package com.xiaotao.eshop.manager.mapper;

import com.xiaotao.eshop.manager.pojo.Content;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);

    List<Content> queryContentListByCid(Long cid);
}