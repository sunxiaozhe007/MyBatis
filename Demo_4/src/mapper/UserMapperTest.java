package mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;

import static org.junit.Assert.*;

public class UserMapperTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");

    @Test
    public void findUserById() {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        User user = userMapper.findUserById(1);

        System.out.println(user);
    }
}