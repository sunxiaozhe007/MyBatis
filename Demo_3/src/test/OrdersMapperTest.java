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

    //��ȡ�����ļ�
    String url = "config/SqlMapConfig.xml";
    InputStream inputStream;
    {
        try {
            inputStream = Resources.getResourceAsStream(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //����SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    @Test
    public void findOrdersAndUser() {
        //����OrderMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<OrdersExt> list = ordersMapper.findOrdersAndUser();
        System.out.println(list);

        sqlSession.close();

    }

    @Test
    public void findOrdersAndUserResultMap() {
        //����OrderMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<OrdersExt> list = ordersMapper.findOrdersAndUserResultMap();

        sqlSession.close();

    }

    @Test
    public void findOrdersAndDetailRstMap() {
        //����OrderMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<OrdersExt> list = ordersMapper.findOrdersAndDetailRstMap();
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void findUserAndItemsRstMap() {
        //����OrderMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<User> list = ordersMapper.findUserAndItemsRstMap();
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void findOrderAndUserLazyLoading() {
        //����OrderMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);


        List<OrdersExt> list = ordersMapper.findOrderAndUserLazyLoading();

        for (OrdersExt order : list){
            System.out.println(order.getUser());
        }
        sqlSession.close();

    }

}