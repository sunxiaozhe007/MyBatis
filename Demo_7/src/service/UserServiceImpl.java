package service;

import domain.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    /**
     * 自动注入UserMapper
     * @param loginname
     * @param password
     * @return
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名和密码查找用户
     * @param loginname
     * @param password
     * @return
     */
    @Override
    public User login(String loginname, String password) {

        System.out.println(loginname);
        System.out.println(password);

        return userMapper.findWithLoginnameAndPassword(loginname,password);
    }
}
