package com.xiaotao.eshop.controller;

//import com.xiaotao.eshop.manager.pojo.Item;
//import com.xiaotao.eshop.service.ItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.EasyUIDataGridResult;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.manager.pojo.Item;
import com.xiaotao.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 13725 on 2018/4/6.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    //将body中bean返回json对象
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId)//取路径后面的参数
    {
        return itemService.getItemById(itemId);
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }


    /**
     * 添加商品
     *
     * @param item
     * @param desc
     * @return
     */
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addItem(Item item, String desc) {
        return itemService.addItem(item, desc);
    }
}
