package Mapper;

import po.User;
import po.UserQueryVO;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    //根据用户id查询信息
    public User findUserById(int id) throws IOException;
    //添加用户
    public void insertUser(User user);
    //综合查询
    public List<User> findUserList(UserQueryVO vo);
    //综合查询用户数
    public int findUserCount(UserQueryVO vo);
    //resultMap入门
    public User findUserRstMap(int id);
}
