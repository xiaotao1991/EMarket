package com.xiaotao.eshop.service.imply;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaotao.common.pojo.EasyUIDataGridResult;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.common.utils.IDUtils;
import com.xiaotao.eshop.manager.mapper.ItemDescMapper;
import com.xiaotao.eshop.manager.mapper.ItemMapper;
import com.xiaotao.eshop.manager.pojo.Item;
import com.xiaotao.eshop.manager.pojo.ItemDesc;
import com.xiaotao.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 13725 on 2018/4/6.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ItemDescMapper itemDescMapper;

    @Override
    public Item getItemById(Long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    /**
     * @param page 请求第几页
     * @param row  总共有多少页
     * @return
     */
    @Override
    public EasyUIDataGridResult getItemList(int page, int row) {
        PageHelper.startPage(page, row);
        List<Item> itemList = itemMapper.queryAll();
        PageInfo<Item> pageInfo = new PageInfo<>(itemList);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public E3Result addItem(Item item, String desc) {
        //生成商品ID
        long itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        itemMapper.insert(item);

        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDescMapper.insert(itemDesc);

        return E3Result.ok();
    }
}
