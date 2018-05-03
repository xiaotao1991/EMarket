package com.xiaotao.eshop.manager.mapper;

import com.xiaotao.eshop.manager.pojo.ItemDesc;

public interface ItemDescMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(ItemDesc record);

    int insertSelective(ItemDesc record);

    ItemDesc selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(ItemDesc record);

    int updateByPrimaryKeyWithBLOBs(ItemDesc record);

    int updateByPrimaryKey(ItemDesc record);
}