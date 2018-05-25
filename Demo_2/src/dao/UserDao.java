package dao;

import po.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    //�����û�id��ѯ��Ϣ
    public User findUserById(int id) throws IOException;
    //�����û�����ģ����ѯ
    public List<User> findByUserName(String name);
    //����û�
    public void insertUser(User user);
}
