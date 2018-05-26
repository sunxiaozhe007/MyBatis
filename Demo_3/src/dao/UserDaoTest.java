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
    //��ȡ�����ļ�
    String url = "config/SqlMapConfig.xml";
    InputStream inputStream;
    {
        try {
            inputStream = Resources.getResourceAsStream(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //����SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    @Test
    public void findUserById() throws IOException {
        //����UserDao
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