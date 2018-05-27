package mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.Items;
import po.ItemsExample;

import java.util.List;

import static org.junit.Assert.*;

public class ItemsMapperTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");


    @Test
    public void selectByExample() {
       ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");

        ItemsExample example = new ItemsExample();
        ItemsExample.Criteria criteria = example.createCriteria();

        criteria.andNameLike("%»ú%");

        List<Items> list = itemsMapper.selectByExample(example);

        System.out.println(list);

    }
}