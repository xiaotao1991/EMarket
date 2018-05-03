package com.xiaotao.eshop.manager.mapper;

import com.xiaotao.eshop.manager.pojo.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}