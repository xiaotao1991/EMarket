package com.xiaotao.eshop.content.service.impl;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.content.service.ContentCategoryService;
import com.xiaotao.eshop.manager.mapper.ContentCategoryMapper;
import com.xiaotao.eshop.manager.mapper.ContentMapper;
import com.xiaotao.eshop.manager.pojo.ContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 13725 on 2018/4/9.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCatList(Long parentId) {

        List<ContentCategory> categoryList = contentCategoryMapper.queryContentCategoryByParentId(parentId);

        ArrayList<EasyUITreeNode> treeNodes = new ArrayList<>();
        for (ContentCategory contentCategory : categoryList) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setText(contentCategory.getName());
            node.setId(contentCategory.getId());
            node.setState(contentCategory.getIsParent() ? "closed" : "open");
            treeNodes.add(node);
        }
        return treeNodes;
    }

    @Override
    public E3Result addContentCategory(long parentId, String name) {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        contentCategory.setStatus(1);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setIsParent(false);
        contentCategory.setUpdated(new Date());

        contentCategoryMapper.insertSelective(contentCategory);
        //更新父节点信息
        ContentCategory parentContent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parentContent.getIsParent()) {
            parentContent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parentContent);
        }

        return E3Result.ok();
    }
}
