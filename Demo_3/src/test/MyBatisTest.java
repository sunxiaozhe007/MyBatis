package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import po.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    /**
     * 通过id查询
     * @throws IOException
     */

    @Test
    public void findUserById() throws IOException {
        //读取配置文件
        String url = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);

        //创建SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一表示
        User user = sqlSession.selectOne("test.findUserById",10);
        System.out.println(user);

        //关闭资源
        sqlSession.close();
    }

    /**
     * 通过姓名模糊查询
     * @throws IOException
     */
    @Test
    public void findUserByName() throws IOException {
        //读取配置文件
        String url = "src/config/SqlMapConfig.xml";
        InputStream inputStream = new FileInputStream(url);

        //创建SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一表示
        List<User> list =  sqlSession.selectList("test.findUserByName","小明");
        System.out.println(list);
        //关闭资源
        sqlSession.close();
    }


    /**
     * 添加用户
     * @throws IOException
     */
    @Test
    public void insertUser() throws IOException {
        //读取配置文件
        String url = "src/config/SqlMapConfig.xml";
        InputStream inputStream = new FileInputStream(url);

        //创建SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一表示
        User user = new User();
        user.setUsername("孙晓哲");
        user.setAddress("西安");
        user.setSex("男");
        sqlSession.insert("test.insertUser",user);

        System.out.println(user.getId());

        //提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }


}
