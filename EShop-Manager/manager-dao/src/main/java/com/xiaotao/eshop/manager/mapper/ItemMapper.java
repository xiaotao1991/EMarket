package com.xiaotao.eshop.manager.mapper;

import com.xiaotao.eshop.manager.pojo.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> queryAll();
}