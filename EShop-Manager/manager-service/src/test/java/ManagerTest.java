import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaotao.eshop.manager.mapper.ItemMapper;
import com.xiaotao.eshop.manager.pojo.Item;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 13725 on 2018/4/7.
 */
public class ManagerTest {

    @Test
    public void testPageHelper(){

        ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        ItemMapper itemMapper = ct.getBean(ItemMapper.class);
        PageHelper.startPage(1,10);
        List<Item> items = itemMapper.queryAll();
        PageInfo<Item> pageInfo = new PageInfo<>(items);

        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getList().size());
    }
}
