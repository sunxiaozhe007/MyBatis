package Mapper;

import po.User;
import po.UserQueryVO;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    //�����û�id��ѯ��Ϣ
    public User findUserById(int id) throws IOException;
    //����û�
    public void insertUser(User user);
    //�ۺϲ�ѯ
    public List<User> findUserList(UserQueryVO vo);
    //�ۺϲ�ѯ�û���
    public int findUserCount(UserQueryVO vo);
    //resultMap����
    public User findUserRstMap(int id);
}
