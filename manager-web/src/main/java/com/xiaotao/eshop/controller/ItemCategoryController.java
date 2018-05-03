package com.xiaotao.eshop.controller;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.eshop.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 13725 on 2018/4/7.
 */
@Controller
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        return itemCategoryService.getItemCatList(parentId);
    }

}
