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

public class MyBatisTest {

    @Test
    public void findUserByIdTest() throws IOException {
        //读取配置文件
        String url = "SqlMapConfig.xml";
        InputStream inputStream = new FileInputStream(url);

        //创建SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一表示
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);

        //关闭资源
        sqlSession.close();
    }
}
