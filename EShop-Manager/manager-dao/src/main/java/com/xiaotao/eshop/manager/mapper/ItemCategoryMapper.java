package com.xiaotao.eshop.manager.mapper;

import com.xiaotao.eshop.manager.pojo.ItemCategory;

import java.util.List;

public interface ItemCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCategory record);

    int insertSelective(ItemCategory record);

    ItemCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCategory record);

    int updateByPrimaryKey(ItemCategory record);

    List<ItemCategory> queryItemCategoryByParentId(Long parentId);
}