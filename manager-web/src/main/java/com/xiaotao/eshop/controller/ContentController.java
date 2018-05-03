package com.xiaotao.eshop.controller;

import com.xiaotao.common.utils.E3Result;
import com.xiaotao.eshop.content.service.ContentService;
import com.xiaotao.eshop.manager.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 13725 on 2018/4/9.
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "content/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(Content content) {
        return contentService.addContent(content);
    }

}
