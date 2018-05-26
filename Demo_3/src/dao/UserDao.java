package dao;

import po.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    //根据用户id查询信息
    public User findUserById(int id) throws IOException;
    //根据用户姓名模糊查询
    public List<User> findByUserName(String name);
    //添加用户
    public void insertUser(User user);
}
