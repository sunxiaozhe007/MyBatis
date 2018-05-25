package Mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import po.User;
import po.UserQueryVO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
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
    public void findUserById() throws IOException {
        //����UserMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //��mybatisͨ��sqlsession�������������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void insertUser() {
        //����UserMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //��mybatisͨ��sqlsession�������������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("��");
        userMapper.insertUser(user);

        System.out.println(user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findUserList() throws IOException {
        //����UserMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //��mybatisͨ��sqlsession�������������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVO vo = new UserQueryVO();
        User user = new User();
        user.setUsername("��");
        //user.setSex("1");
        vo.setUser(user);

        List<User> list =  userMapper.findUserList(vo);
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void findUserCount() throws IOException {
        //����UserMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //��mybatisͨ��sqlsession�������������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVO vo = new UserQueryVO();
//        User user = new User();
//        user.setUsername("��");
//        user.setSex("1");
//        vo.setUser(user);
        List<Integer> idlist = new ArrayList();
        idlist.add(1);
        idlist.add(10);

        vo.setIdlist(idlist);

        List<User> list =  userMapper.findUserList(vo);
        int count = userMapper.findUserCount(vo);
        System.out.println(list);
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void findUserRstMap() throws IOException {
        //����UserMapper����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //��mybatisͨ��sqlsession�������������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserRstMap(1);
        System.out.println(user);
        sqlSession.close();
    }
}