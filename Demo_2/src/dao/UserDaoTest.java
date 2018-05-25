package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import po.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserDaoTest {
    //读取配置文件
    String url = "config/SqlMapConfig.xml";
    InputStream inputStream;
    {
        try {
            inputStream = Resources.getResourceAsStream(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    @Test
    public void findUserById() throws IOException {
        //创建UserDao
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(10);
        System.out.println(user);
    }

    @Test
    public void findByUserName() {
    }

    @Test
    public void insertUser() {
    }
}