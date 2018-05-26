package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.User;
import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //“¿¿µ◊¢»Î
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl (SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById",id);

        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findByUserName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list =  sqlSession.selectList("test.findUserByName",name);
        System.out.println(list);
        sqlSession.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
