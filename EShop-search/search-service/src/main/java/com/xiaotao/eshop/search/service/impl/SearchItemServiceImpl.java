package com.xiaotao.eshop.search.service.impl;

import com.xiaotao.common.pojo.SearchItem;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.common.utils.JsonUtils;
import com.xiaotao.eshop.search.service.SearchItemService;
import com.xiaotao.eshop.search.service.mapper.ItemSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 13725 on 2018/4/11.
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private ItemSearchMapper itemSearchMapper;

    @Override
    public E3Result importAllItems() {
        List<SearchItem> items = itemSearchMapper.queryItemList();
        String json = JsonUtils.objectToJson(items);
        System.out.println("backJson" + json);
        return E3Result.ok();
    }
}
