package dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;

public class UserDaoTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");

    @Test
    public void findUserById() {

        //´´½¨UserDao
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        User user = userDao.findUserById(1);

        System.out.println(user);

    }
}