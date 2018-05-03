package com.xiaotao.eshop.service;

import com.xiaotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by 13725 on 2018/4/7.
 */
public interface ItemCategoryService {

    List<EasyUITreeNode> getItemCatList(long parentId);

}
