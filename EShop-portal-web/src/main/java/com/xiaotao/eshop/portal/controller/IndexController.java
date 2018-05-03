package com.xiaotao.eshop.portal.controller;

import com.xiaotao.eshop.content.service.ContentService;
import com.xiaotao.eshop.manager.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 13725 on 2018/4/9.
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @Value("${CONTENT_LUNBO}")
    private Long CONTENT_LUNBO;

    /**
     * 配置首页不用加index
     *
     * @return
     */
    @RequestMapping("/index")
    public String showIndex(Model model) {
        List<Content> contentList = contentService.getContentListByCid(CONTENT_LUNBO);
        model.addAttribute("add1List", contentList);
        return "index";
    }
}
