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
     * ͨ��id��ѯ
     * @throws IOException
     */

    @Test
    public void findUserById() throws IOException {
        //��ȡ�����ļ�
        String url = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);

        //����SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����SqlSession����ɾ�Ĳ鷽��
        //��һ����������ʾstatement��Ψһ��ʾ
        User user = sqlSession.selectOne("test.findUserById",10);
        System.out.println(user);

        //�ر���Դ
        sqlSession.close();
    }

    /**
     * ͨ������ģ����ѯ
     * @throws IOException
     */
    @Test
    public void findUserByName() throws IOException {
        //��ȡ�����ļ�
        String url = "src/config/SqlMapConfig.xml";
        InputStream inputStream = new FileInputStream(url);

        //����SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����SqlSession����ɾ�Ĳ鷽��
        //��һ����������ʾstatement��Ψһ��ʾ
        List<User> list =  sqlSession.selectList("test.findUserByName","С��");
        System.out.println(list);
        //�ر���Դ
        sqlSession.close();
    }


    /**
     * ����û�
     * @throws IOException
     */
    @Test
    public void insertUser() throws IOException {
        //��ȡ�����ļ�
        String url = "src/config/SqlMapConfig.xml";
        InputStream inputStream = new FileInputStream(url);

        //����SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����SqlSession����ɾ�Ĳ鷽��
        //��һ����������ʾstatement��Ψһ��ʾ
        User user = new User();
        user.setUsername("������");
        user.setAddress("����");
        user.setSex("��");
        sqlSession.insert("test.insertUser",user);

        System.out.println(user.getId());

        //�ύ����
        sqlSession.commit();
        //�ر���Դ
        sqlSession.close();
    }


}
