package com.xiaotao.eshop.service;

import com.xiaotao.common.pojo.EasyUIDataGridResult;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.manager.pojo.Item;

/**
 * Created by 13725 on 2018/4/6.
 */
public interface ItemService {

    Item getItemById(Long itemId);

    EasyUIDataGridResult getItemList(int page, int row);

    E3Result addItem(Item item, String desc);
}
