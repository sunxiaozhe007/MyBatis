package test;

import Mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import po.Orders;
import po.OrdersExt;
import po.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersMapperTest {

    //读取配置文件
    String url = "config/SqlMapConfig.xml";
    InputStream inputStream;
    {
        try {
            inputStream = Resources.getResourceAsStream(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //创建SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    @Test
    public void findOrdersAndUser() {
        //创建OrderMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<OrdersExt> list = ordersMapper.findOrdersAndUser();
        System.out.println(list);

        sqlSession.close();

    }

    @Test
    public void findOrdersAndUserResultMap() {
        //创建OrderMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<OrdersExt> list = ordersMapper.findOrdersAndUserResultMap();

        sqlSession.close();

    }

    @Test
    public void findOrdersAndDetailRstMap() {
        //创建OrderMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<OrdersExt> list = ordersMapper.findOrdersAndDetailRstMap();
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void findUserAndItemsRstMap() {
        //创建OrderMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<User> list = ordersMapper.findUserAndItemsRstMap();
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void findOrderAndUserLazyLoading() {
        //创建OrderMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<OrdersExt> list = ordersMapper.findOrderAndUserLazyLoading();

        for (OrdersExt order : list){
            System.out.println(order.getUser());
        }
        sqlSession.close();

    }

}