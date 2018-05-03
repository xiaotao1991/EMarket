package com.xiaotao.eshop.controller;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.content.service.ContentCategoryService;
import com.xiaotao.eshop.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 13725 on 2018/4/9.
 */
@Controller
public class ContentCatController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        return contentCategoryService.getContentCatList(parentId);
    }

    /**
     * 添加分类节点
     */
    @RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(Long parentId, String name) {
        return contentCategoryService.addContentCategory(parentId, name);
    }

}
