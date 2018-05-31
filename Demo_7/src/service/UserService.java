package service;

import domain.User;

public interface UserService {
    /**
     * 判断用户登陆
     */
    User login(String loginname, String password);
}
