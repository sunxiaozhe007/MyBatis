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
        //��ȡ�����ļ�
        String url = "SqlMapConfig.xml";
        InputStream inputStream = new FileInputStream(url);

        //����SqlSessionFactory

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����SqlSession����ɾ�Ĳ鷽��
        //��һ����������ʾstatement��Ψһ��ʾ
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);

        //�ر���Դ
        sqlSession.close();
    }
}
