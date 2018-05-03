package com.xiaotao.search.test;

import com.xiaotao.eshop.search.service.impl.SearchItemServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 13725 on 2018/4/11.
 */
public class SearchTest {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        SearchItemServiceImpl service = context.getBean(SearchItemServiceImpl.class);
        service.importAllItems();
    }

}
