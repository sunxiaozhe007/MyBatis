package dao;

import po.User;

public interface UserDao {
    //�����û�ID��ѯ�û���Ϣ
    public User findUserById(int id);
}
