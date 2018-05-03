package com.xiaotao.eshop.controller;

import com.xiaotao.common.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13725 on 2018/4/9.
 * 文件上传
 */
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map uploadFile(MultipartFile uploadFile) {
        //将文件上传至文件服务器
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:/conf/client.conf");
            String filename = uploadFile.getOriginalFilename();
            String extName = filename.substring(filename.lastIndexOf(".") + 1);
            String imageUrl = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            imageUrl = IMAGE_SERVER_URL + imageUrl;

            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("error", 0);
            hashMap.put("url", imageUrl);

            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("error", 1);
            hashMap.put("url", "1");
            return hashMap;
        }
    }
}
