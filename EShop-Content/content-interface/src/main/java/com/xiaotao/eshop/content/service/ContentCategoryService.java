package com.xiaotao.eshop.content.service;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.common.utils.E3Result;

import java.util.List;

/**
 * Created by 13725 on 2018/4/9.
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCatList(Long parentId);

    E3Result addContentCategory(long parentId, String name);
}
