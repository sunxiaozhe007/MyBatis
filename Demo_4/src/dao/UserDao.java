package dao;

import po.User;

public interface UserDao {
    //根据用户ID查询用户信息
    public User findUserById(int id);
}
