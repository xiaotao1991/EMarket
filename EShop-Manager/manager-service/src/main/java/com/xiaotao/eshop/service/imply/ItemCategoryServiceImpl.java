package com.xiaotao.eshop.service.imply;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.eshop.manager.mapper.ItemCategoryMapper;
import com.xiaotao.eshop.manager.pojo.ItemCategory;
import com.xiaotao.eshop.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13725 on 2018/4/7.
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryMapper itemCategoryMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        List<ItemCategory> itemCategories = itemCategoryMapper.queryItemCategoryByParentId(parentId);

        ArrayList<EasyUITreeNode> nodes = new ArrayList<>();
        for (ItemCategory itemCategory : itemCategories) {
            EasyUITreeNode treeNode = new EasyUITreeNode();
            treeNode.setId(itemCategory.getId());
            treeNode.setState(itemCategory.getIsParent() ? "closed" : "open");
            treeNode.setText(itemCategory.getName());
            nodes.add(treeNode);
        }

        return nodes;
    }
}
