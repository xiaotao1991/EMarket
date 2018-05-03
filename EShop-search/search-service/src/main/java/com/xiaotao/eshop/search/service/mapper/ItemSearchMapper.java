package com.xiaotao.eshop.search.service.mapper;

import com.xiaotao.common.pojo.SearchItem;

import java.util.List;

public interface ItemSearchMapper {

    List<SearchItem> queryItemList();
}