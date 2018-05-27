package mapper;

import po.User;

public interface UserMapper {
    //根据用户id查询信息
    public User findUserById(int id);
}
