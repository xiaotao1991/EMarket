package com.xiaotao.eshop.portal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 13725 on 2018/4/11.
 * 全局异常处理
 */
public class GloableExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GloableExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();
        logger.error("GloableExceptionResolver", e);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/exception");
        return modelAndView;
    }
}
